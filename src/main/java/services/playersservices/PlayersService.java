package services.playersservices;

import models.Player;

import java.util.List;

public interface PlayersService {
    List<Player> getAllPlayersByCountry(Integer id);
    String getClub(Player player);
    String getColumnByName(String columnName, String name);
}
