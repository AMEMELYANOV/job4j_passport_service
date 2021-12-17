package ru.job4j.postservice.service;

import ru.job4j.passport.domain.Passport;

public interface PostService {
    void sendPost(Passport passport);
}
