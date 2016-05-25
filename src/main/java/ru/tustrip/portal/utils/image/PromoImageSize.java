package ru.tustrip.portal.utils.image;

/**
 * Created by antonorlov on 24/05/16.
 */
public enum PromoImageSize {

    SMALL(150), MEDIUM(350), LARGE(1000);
    private int width;

    PromoImageSize(final int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

}
