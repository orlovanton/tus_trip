package ru.tustrip.portal.mock;

import ru.tustrip.portal.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by antonorlov on 20/05/16.
 */
public class BaseMock {

    public static Agent getAgent() {

        Location location = new Location();
        location.setCity("Спб");
        location.setCountry("Россия");
        Agent agent = new Agent();
        agent.setName("Тус-Трипс");
        ;
        agent.setLocation(location);
        agent.setActivityList(getActivityList());
        return agent;
    }


    public static Tour getTour(int num) {


        Tour tour = new Tour();
        if (num == 0) {
            tour.setName("Незабываемый год в Бобруйске");
            tour.setActivityList(getActivityList());

            tour.setPrice(100000.00);

            Location location = new Location();
            location.setCity("Бобруйск");
            location.setCountry("Белорусия");
            tour.setLocation(location);
            tour.setAgent(getAgent());
            tour.setCurrency(Currency.RUB);
            tour.setDiscount(1000.00);
            tour.setStartDate(new Date());
            tour.setEndDate(new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 365)));
            tour.setIsPublished(true);
            tour.setIsFlightIncluded(false);
            tour.setMainImageUrl("test_image.jpg");
            tour.setDescription("Lorem Ipsum - это текст-\"рыба\", часто используемый в печати и вэб-дизайне. Lorem Ipsum является стандартной \"рыбой\" для текстов на латинице с начала XVI века. В то время некий безымянный печатник создал большую коллекцию размеров и форм шрифтов, используя Lorem Ipsum для распечатки образцов. Lorem Ipsum не только успешно пережил без заметных изменений пять веков, но и перешагнул в электронный дизайн. Его популяризации в новое время послужили публикация листов Letraset с образцами Lorem Ipsum в 60-х годах и, в более недавнее время, программы электронной вёрстки типа Aldus PageMaker, в шаблонах которых используется Lorem Ipsum.");

        } else {
            tour.setName("Пляжи челябинска");
            tour.setActivityList(getActivityList());
            tour.setPrice(17000.00);
            Location location = new Location();
            location.setCity("Челябинск");
            location.setCountry("Россия");
            tour.setLocation(location);
            tour.setAgent(getAgent());
            tour.setCurrency(Currency.RUB);
            tour.setDiscount(0.00);
            tour.setStartDate(new Date());
            tour.setEndDate(new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 365)));
            tour.setIsPublished(true);
            tour.setIsFlightIncluded(false);
            tour.setMainImageUrl("test_image.jpg");
            tour.setDescription("Lorem Ipsum - это текст-\"рыба\", часто используемый в печати и вэб-дизайне. Lorem Ipsum является стандартной \"рыбой\" для текстов на латинице с начала XVI века. В то время некий безымянный печатник создал большую коллекцию размеров и форм шрифтов, используя Lorem Ipsum для распечатки образцов. Lorem Ipsum не только успешно пережил без заметных изменений пять веков, но и перешагнул в электронный дизайн. Его популяризации в новое время послужили публикация листов Letraset с образцами Lorem Ipsum в 60-х годах и, в более недавнее время, программы электронной вёрстки типа Aldus PageMaker, в шаблонах которых используется Lorem Ipsum.");
        }
        return tour;
    }

    private static List<Activity> getActivityList() {
        Activity activity = new Activity();
        activity.setName("Сноуборд");
        List<Activity> activityList = new ArrayList<>();
        activityList.add(activity);

        return activityList;
    }
}
