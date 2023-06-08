package com.br.marcelo.lojateste.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_vendas")
public class Vendas extends Cadastro{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,name = "Tp_doce",length = 30)
    private String tiposdedoce;
    @Column(nullable = false,name = "Quantidade",length = 5)
    private int quantidade;
    @Column(nullable = false,name = "V_Total",length = 5)
    private float valotTotal;
    @Column(nullable = false,name = "Cliente",length = 40)
    private String cliente;
    @Column(nullable = false,name = "F_Pagamento",length = 10)
    private String formaDePagamento;
    @Column(nullable = false,name = "Dt_Compra",length = 10)
    private String dataDaCompra;
    @Column(nullable = false,name = "VPago",length = 30)
    private boolean valorPago;

}
