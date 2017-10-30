package services.clubsservices;

import dao.clubsdao.ClubsDao;

public class ClubServiceImpl implements ClubService {

    private ClubsDao clubsDao;

    public ClubServiceImpl(ClubsDao clubsDao) {
        this.clubsDao = clubsDao;
    }

    @Override
    public String getLogoByName(String name) {
        return clubsDao.getLogo(name);
    }
}
