package io.acortador.service;

import io.acortador.model.Urls;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IProxyService {
    public String toProxy ();
    public List<Urls> listar();
}
