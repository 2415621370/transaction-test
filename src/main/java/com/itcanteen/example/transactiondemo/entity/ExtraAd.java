package com.itcanteen.example.transactiondemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2019/10/17 16:49
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="extra_ad")
public class ExtraAd {


    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="name",nullable = false)
    @Basic
    private String name;

    public ExtraAd(String name){
        this.name = name;
    }
}
