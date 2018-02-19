package OnlineAuction.service;


import OnlineAuction.entity.Plumb;

import java.util.List;

public interface PlumbService {

    void save(Plumb plumb);
    void delete(int id);
    Plumb findOne(int id);
    List<Plumb> findAll();
}
