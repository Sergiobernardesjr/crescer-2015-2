package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.dto.ItemDTO;

public class ItemMapper {

    public static Item newItem(ItemDTO dto) {
        Item item = new Item();
        item.setPeso(dto.getPeso());
        return item;
    }

}
