package br.com.sostecnologia.util;

import org.modelmapper.ModelMapper;

public class MappingUtil<E,T> {

    private ModelMapper modelMapper;

    public MappingUtil() {
        modelMapper = new ModelMapper();
    }

    public T entityToTo (E obj, Class<T> classType) {
        return modelMapper.map(obj, classType);
    }

    public E toToEntity(T obj, Class<E> classType) {
        return modelMapper.map(obj, classType);
    }

}
