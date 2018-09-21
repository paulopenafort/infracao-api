package br.gov.am.prodam.infracao.repository.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public abstract class GenericDAO<T, I> {

	@PersistenceContext
	private EntityManager entityManager;

	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public GenericDAO() {

		this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public List<T> findByJPQL(final String jpql, final Map<String, Object> params) {

		final TypedQuery<T> query = this.entityManager.createQuery(jpql, entityClass);

		buildParams(params, query);

		return query.getResultList();
	}

	public Page<T> findByJPQL(final String jpql, final Map<String, Object> params, Pageable pageable) {

		final TypedQuery<T> query = this.entityManager.createQuery(jpql, entityClass);

		buildParams(params, query);

		query.setFirstResult((pageable.getPageNumber() - 1) * pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());
		
		
		List<T> content = query.getResultList();

		long total = getTotal(jpql, params);

		return new PageImpl<>(content, pageable, total);
	}

	public T getByJPQL(final String jpql, final Map<String, Object> params) {
		final TypedQuery<T> query = this.entityManager.createQuery(jpql, this.entityClass);
		this.buildParams(params, query);
		return query.getSingleResult();
	}

	protected long getTotal(final String jpql, final Map<String, Object> params) {
		final String jpqlCount = this.createCountQuery(jpql);
		
		
		final Query countQuery = this.entityManager.createQuery(jpqlCount);

		this.buildParams(params, countQuery);

		return (long) countQuery.getSingleResult();

	}

	protected void buildParams(final Map<String, Object> params, final Query query) {
		if (params != null) {
			for (final Map.Entry<String, Object> param : params.entrySet()) {
				if (param.getValue() instanceof Date) {
					query.setParameter(param.getKey(), (Date) param.getValue(), TemporalType.TIMESTAMP);
				}
				query.setParameter(param.getKey(), param.getValue());
			}
		}
	}

	protected String createCountQuery(final String jpql) {

		final String query = jpql.trim();

		Matcher matcher = Pattern.compile("[Ss][Ee][Ll][Ee][Cc][Tt](.+)[Ff][Rr][Oo][Mm]").matcher(query);

		if (matcher.find()) {
			final String[] split = query.trim().split(" ");

			if ("distinct".equalsIgnoreCase(split[1])) {
				split[1] = " COUNT(DISTINCT " + split[2] + ") ";
				split[2] = "";
			} else {
				split[1] = " COUNT(" + split[1] + ") ";
			}

			final String result = Arrays.stream(split).collect(Collectors.joining(" "));

			matcher = Pattern.compile("(.+)[Oo][Rr][Dd][Ee][Rr](.+)").matcher(result);

			if (matcher.find()) {
				return matcher.group(1);
			}

			return result;
		} else {
			throw new RuntimeException("JPQL Inválida");
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

}
