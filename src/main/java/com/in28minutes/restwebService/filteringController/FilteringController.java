/*package com.in28minutes.restwebService.filteringController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// to serialize all except field1 andfield2 (like a put call remove created date)
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");

		@SuppressWarnings("deprecation")
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept(new HashSet<>(Arrays.asList("field1", "field2")));

		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(someBean);

		mapping.setFilters(filters);

		return mapping;
	}

	// Seruakuze all (Like Post Call providing created date.)
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfSomeBeans() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
				new SomeBean("value12", "value22", "value32"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAll();
		//SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");

		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(list);

		mapping.setFilters(filters);

		return mapping;
	}

	@PostMapping("/filterpost")
	public MappingJacksonValue postOfSomeBean(@RequestBody SomeBean somebean)
	{
		logger.info("The some bean details is"+somebean.getField1());
		SomeBean som1=new SomeBean();
		som1.setField1(somebean.getField1());
		som1.setField2(somebean.getField2());
		som1.setField3(somebean.getField3());
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAll();
		//SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");

		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(som1);

		mapping.setFilters(filters);

		return mapping;	
		}
}*/
