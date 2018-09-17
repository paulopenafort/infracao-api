package br.gov.am.prodam.infracao.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class BasicService<T, ID extends Serializable, R extends JpaRepository<T, ID>> {

	@Autowired
	protected R repository;

	public List<T> findAll() {
		return repository.findAll();
	}

	public Optional<T> findById(ID id) {
		return repository.findById(id);
	}

	@Transactional
	public T save(T entity) {
		return this.repository.saveAndFlush(entity);
	}

	@Transactional
	public T update(T entity) {
		return this.repository.saveAndFlush(entity);
	}

	public void delete(ID id) {
		this.repository.deleteById(id);
	}

	public Page<T> findAll(Pageable pageable) {
		return this.repository.findAll(pageable);
	}

	public void deleteById(ID id) {
		this.repository.deleteById(id);
	}

	public <S extends T> Optional<S> findOne(Example<S> example) {
		return repository.findOne(example);
	}

	public List<T> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	public List<T> findAllById(Iterable<ID> ids) {
		return repository.findAllById(ids);
	}

	public <S extends T> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	public boolean existsById(ID id) {
		return repository.existsById(id);
	}

	public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	public long count() {
		return repository.count();
	}

	public T getOne(ID id) {
		return repository.getOne(id);
	}

	public void delete(T entity) {
		repository.delete(entity);
	}

	public <S extends T> long count(Example<S> example) {
		return repository.count(example);
	}

	public <S extends T> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	public <S extends T> boolean exists(Example<S> example) {
		return repository.exists(example);
	}

	public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}

}