package io.acortador.validator;

import org.springframework.stereotype.Service;

@Service
public interface IShorterValidator {
    public Boolean isURLValid(String someURL);
    public String toWorkerURL(String someUrl);
}
