public class ItemService {
    ItemDAO itemDAO = new ItemDAO();

    public Item update(Item item) throws Exception {
        if (item == null || item.getId() == null) {
            throw new Exception("id не может быть пустым или равно 0");
        }

        return itemDAO.update(item);
    }

    public Item save(Item item) {
        return itemDAO.save(item);
    }

    public void delete(Long id) throws Exception {
        if (id == null || id == 0) {
            throw new Exception("id не может быть пустым или равно 0");
        }

        itemDAO.delete(id);
    }
}
