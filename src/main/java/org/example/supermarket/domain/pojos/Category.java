package org.example.supermarket.domain.pojos;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    private Integer id;
    private String categoryName;
    private String categoryPicture;
    private String description;
}
