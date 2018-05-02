package OnlineAuction.service;

import OnlineAuction.entity.User;


public interface MailService {
    void sendByUser(User user, String message);
    void sendByEmail(String email, String message);
}
