package com.example.demo.service;


import com.example.demo.entity.Suscripcion;

public interface ISuscripcionService {

    Suscripcion createSuscription(Suscripcion suscripcion);
    Suscripcion getSuscriptionById(Integer id);
    Suscripcion getSuscripcionForIdproveedor(String idproveedor);
    Suscripcion cancelSuscription(String idproveedor);
    Suscripcion updateSuscripcioon(String idproveedor);

}
