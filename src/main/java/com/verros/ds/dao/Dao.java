package com.verros.ds.dao;

import com.verros.rest.dto.CheckDigitDto;

import java.util.List;

public interface Dao<T> {

  void add(T t);

  <T> List<T> getAll(Class<T> t);

  void delete(Integer id);

  void update(CheckDigitDto checkDigitDto);
}
