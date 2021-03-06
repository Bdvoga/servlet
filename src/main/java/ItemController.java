public class ItemController {
    ItemService itemService = new ItemService();

    public Item update(Item item) throws Exception {
        return itemService.update(item);
    }

    public Item save(Item item) {
        return itemService.save(item);
    }

    public void delete(Long id) throws Exception {
        itemService.delete(id);
    }
}
