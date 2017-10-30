package services.countriesservices;

import dao.countriesdao.CountriesDao;
import models.Country;

import java.util.List;


public class CountryServiceImpl implements CountryService {

    private CountriesDao countriesDao;

    public CountryServiceImpl(CountriesDao countriesDao) {
        this.countriesDao = countriesDao;
    }

    @Override
    public List<Country> getAllCountries() {
        return countriesDao.findALL();
    }

    @Override
    public String getColumnByName(String columnName, String name) {
        return countriesDao.getColumnByName(columnName, name);
    }


}
