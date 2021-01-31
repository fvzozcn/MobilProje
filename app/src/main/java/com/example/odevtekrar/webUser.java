package com.example.odevtekrar;

public class webUser {
    String filmAdi;
    String filmYil;
    String _th;

    public webUser(String filmAdi, String filmYil, String filmThumb) {
        this.filmAdi = filmAdi;
        this.filmYil = filmYil;
        this._th = filmThumb;
    }

    public String getFilmAdi() {
        return filmAdi;
    }

    public String getFilmYil() {
        return filmYil;
    }

    public String getFilmThumb() {
        return _th;
    }
}
