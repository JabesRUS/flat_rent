package com.javaacademy.flat_rent.service.impl;

import com.javaacademy.flat_rent.dto.AdvertDtoRq;
import com.javaacademy.flat_rent.dto.AdvertDtoRsp;
import com.javaacademy.flat_rent.entity.Advert;
import com.javaacademy.flat_rent.mapper.AdvertMapper;
import com.javaacademy.flat_rent.repository.AdvertRepository;
import com.javaacademy.flat_rent.service.api.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {
    public static final int FIRST_PAGE = 0;
    public static final int TEN_ENTRIES = 10;
    public static final String ORDER_BY_PRICE = "price";
    private final AdvertRepository advertRepository;
    private final AdvertMapper advertMapper;

    @Override
    public AdvertDtoRsp save(AdvertDtoRq advertDtoRq) {
        Advert entityWithRelation = advertMapper.toEntityWithRelation(advertDtoRq);
        Advert saveAdvert = advertRepository.save(entityWithRelation);
        AdvertDtoRsp dtoRsp = advertMapper.toDto(saveAdvert);
        return dtoRsp;
//        return advertMapper.toDto(advertRepository.save(advertMapper.toEntityWithRelation(advertDtoRq)));
    }

    @Override
    public Page<AdvertDtoRsp> getAdvertsByCity(String city, Integer page, Integer size) {
        int numberPage = page == null ? FIRST_PAGE : page;
        int sizePage = size == null ? TEN_ENTRIES : size;
        
        PageRequest pageRequest = PageRequest.of(numberPage, sizePage,
                Sort.by(Sort.Direction.DESC, ORDER_BY_PRICE));
        Page<Advert> adverts = advertRepository.findByApartmentCityOrderByPriceDesc(city, pageRequest);
        return adverts.map(advert -> advertMapper.toDto(advert));
    }
}
