package com.br.marcelo.lojateste.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

//    @Column(name = "DT_Compra", nullable = false, length = 15)
//    private String dtCompra;
//    @Column(name = "DT_Pagamento", nullable = false, length = 15)
//    private String dtPagamento;
    @Column(name = "V_Pago", nullable = false, length = 5)
    private String vPago;
    @Column(name = "Pago", nullable = false, length = 5)
    private String Pago;
    @ManyToMany
    @JoinTable(name = "cliente_vendas",
            joinColumns = @JoinColumn(name = "vendas_fk"),
            inverseJoinColumns = @JoinColumn(name = "cliente_fk"))
    private List<Cliente> clientes;

    @ManyToMany(mappedBy = "clientes")
    List<Vendas> vendas;
}
