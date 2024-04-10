package com.barcode.aviation.tool.inventory.dto;
import com.barcode.aviation.tool.inventory.entities.ToolStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToolDto {
    private Long id;
    private String barcodeId;
    private String name;
    private String picture;
    private ToolStatus status;
    private String pictureUrl;
}
