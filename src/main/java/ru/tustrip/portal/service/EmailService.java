package ru.tustrip.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import ru.tustrip.portal.model.Coupon;
import ru.tustrip.portal.model.PortalUser;
import ru.tustrip.portal.model.Tour;

import java.util.Properties;

/**
 * Created by antonorlov on 26/05/16.
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Autowired
    private UserService userService;

    @Autowired
    private TourService tourService;

//    @PostConstruct
//    public void postConstruct(){
//       mailSender.
//    }

    public void sendCouponEmail(final Coupon coupon) {

        PortalUser user = userService.getUser(coupon.getUserId());

        Tour tour = tourService.getTour(coupon.getTourId());
        // Create a thread safe "copy" of the template message and customize it


        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.auth", true);
        mailProperties.put("mail.smtp.starttls.enable", false);
        mailSender.setJavaMailProperties(mailProperties);

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("admin@velo-line.ru");
        msg.setSubject("Купон");

        String userName = user.getName() == null ? "пользователь" : user.getName();
        msg.setTo(user.getEmail());
        msg.setText(
                "Уважаемый "
                        + userName
                        + ", мы рады что вы выбрали тур "
                        + ". Номер вашего купона: "
                        + coupon.getCode());
        try {
            mailSender.send(msg);
        } catch (MailException ex) {

            // simply log it and go on...
            System.err.println(ex.getMessage());
        }

    }
}
