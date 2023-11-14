package com.br.marcelo.lojateste.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vendas")
public class Vendas extends Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Qtde", nullable = false, length = 5)
    private String qtde;
    @Column(name = "TP_Doces", nullable = false, length = 25)
    private String tPdoces;
    @Column(name = "Q_Total", nullable = false, length = 5)
    private String qTotal;
    @Column(name = "Cliente", nullable = false, length = 30)
    private String cliente;
    @Column(name = "F_Pagamento", nullable = false, length = 15)
    private String fPagamento;
    @Column(name = "V_Pago", nullable = false, length = 5)
    private String vPago;
    @Column(name = "Pago", nullable = false, length = 5)
    private String Pago;
//    @ManyToMany(mappedBy = "clientes")
//        Set<Cliente> clientes;
}
