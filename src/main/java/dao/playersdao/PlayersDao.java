package dao.playersdao;

import dao.CrudDao;
import models.Player;

import java.util.List;

public interface PlayersDao extends CrudDao<Player, Long> {
    List<Player> findAllByClub(Integer clubId);
    List<Player> findAllByCountry(Integer countryId);
    String getClub(Player player);
    String getColumnByName(String columnName, String name);
}
