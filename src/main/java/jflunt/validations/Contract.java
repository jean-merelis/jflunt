package jflunt.validations;

import jflunt.notifications.Notifiable;

public class Contract extends Notifiable implements BarrelValidationContract {

    public Contract requires() {
        return this;
    }

    public Contract join(Notifiable[]... items) {
        if (items != null) {
            for(Notifiable[] varitems: items) {
                for(Notifiable notifiable: varitems) {
                    if (notifiable.isInvalid()) {
                        addNotification(notifiable.getNotifications());
                    }
                }
            }
        }
        
        return this;
    }

    @Override
    public Contract getContract() {
        return this;
    }
}