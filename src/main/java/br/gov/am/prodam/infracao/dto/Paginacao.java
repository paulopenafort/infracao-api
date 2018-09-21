package br.gov.am.prodam.infracao.dto;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class Paginacao {

	@QueryParam("page")
	@DefaultValue("0")
	Integer page;
	
	@QueryParam("size")
	@DefaultValue("10")
	Integer size;
	
	
	@QueryParam("sort")
	List<String> sort;

	public Pageable toPageable() {

		List<Sort.Order> orders = new ArrayList<>();

		for (String propOrder : sort) {
			String[] propOrderSplit = propOrder.split(",");
			String property = propOrderSplit[0];
			if (propOrderSplit.length == 1) {
				orders.add(Sort.Order.by(property));
			} else {
				Sort.Direction direction = Sort.Direction.fromString(propOrderSplit[1]);
				orders.add(new Sort.Order(direction, property));
			}
		}

		return PageRequest.of(page, size, Sort.by(orders));
	}

}
