package com.usa.reto.Model.reporte;

import com.usa.reto.Model.Client;

public class CountClient {
    private Integer total;
    private Client client;

    public CountClient(Integer total,Client client){
        this.total = total;
        this.client = client;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
