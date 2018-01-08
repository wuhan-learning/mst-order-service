package com.thoughtworks.mstorderservice.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    public enum Symbol {
        SYSTEM_ADMIN("系统管理员");

        private String description;

        Symbol(String description) {
            this.description = description;
        }

        public String description() {
            return description;
        }
    }

    private Symbol symbol;

    private String name;

    private List<Privilege> privileges = new ArrayList<>();

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
        name = symbol.description();
    }
}
