package com.verros.ds.dao;

import java.util.List;

public interface Dao<T> {

  void add(T t);

  <T> List<T> getAll(Class<T> t);
}
