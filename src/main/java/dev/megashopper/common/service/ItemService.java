package dev.megashopper.common.service;

import dev.megashopper.common.dtos.ItemResponsePayload;
import dev.megashopper.common.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemResponsePayload> fetchAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(ItemResponsePayload::new)
                .collect(Collectors.toList());
    }

}
