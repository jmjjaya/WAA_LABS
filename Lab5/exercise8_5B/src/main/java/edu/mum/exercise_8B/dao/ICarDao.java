package edu.mum.exercise_8B.dao;

import java.util.List;

import edu.mum.exercise_8B.model.Car;

public interface ICarDao {

	public abstract List<Car> getAll();

	public abstract void add(Car car);

	public abstract Car get(int id);

	public abstract void update(int carId, Car car);

	public abstract void delete(int carId);

}