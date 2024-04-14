package br.com.lanchonete.port.usecase;

import br.com.lanchonete.model.Billing;

public interface GenerateBilling {

    Billing generate(Billing billing);

}
