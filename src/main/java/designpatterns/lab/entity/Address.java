package designpatterns.lab.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// VIACEP: https://viacep.com.br
// ATRIBUTOS GERADOS POR: https://www.jsonschema2pojo.org
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private String cep;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private String complemento;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String localidade;
    @Column(nullable = false)
    private String uf;
    @Column(nullable = false)
    private String ibge;
    @Column(nullable = false)
    private String gia;
    @Column(nullable = false)
    private String ddd;
    @Column(nullable = false)
    private String siafi;
}
