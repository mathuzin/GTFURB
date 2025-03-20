package com.example.gtfurb.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventarioUpdateDto {
    private Integer item;
    private Integer qtdItem;
    private String nmItem;
    @NotNull(message = "inventario.saveId.nulo")
    private UUID saveId;
}
