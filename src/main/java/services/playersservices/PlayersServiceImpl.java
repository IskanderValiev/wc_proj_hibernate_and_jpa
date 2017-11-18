package services.playersservices;

import dao.playersdao.PlayersDao;
import models.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersServiceImpl implements PlayersService {

    private PlayersDao playersDao;

    public PlayersServiceImpl(PlayersDao playersDao) {
        this.playersDao = playersDao;
    }

    @Override
    public List<Player> getAllPlayersByCountry(Integer id) {
        return playersDao.findAllByCountry(id);
    }

    @Override
    public String getClub(Player player) {
        return playersDao.getClub(player);
    }

    @Override
    public String getColumnByName(String columnName, String name) {
        return playersDao.getColumnByName(columnName, name);
    }
}
