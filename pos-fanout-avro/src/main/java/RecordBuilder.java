import types.HadoopRecord;
import types.LineItem;
import types.Notification;
import types.PosInvoice;

import java.util.ArrayList;
import java.util.List;

class RecordBuilder {

    static List<HadoopRecord> getHadoopRecords(PosInvoice invoice) {
        List<HadoopRecord> records = new ArrayList<>();
        for (LineItem i : invoice.getInvoiceLineItems()) {
            HadoopRecord record = new HadoopRecord();
            record.setInvoiceNumber(invoice.getInvoiceNumber());
            record.setCreatedTime(invoice.getCreatedTime());
            record.setStoreID(invoice.getStoreID());
            record.setPosID(invoice.getPosID());
            record.setCustomerType(invoice.getCustomerType());
            record.setPaymentMethod(invoice.getPaymentMethod());
            record.setDeliveryType(invoice.getDeliveryType());
            record.setItemCode(i.getItemCode());
            record.setItemDescription(i.getItemDescription());
            record.setItemPrice(i.getItemPrice());
            record.setItemQty(i.getItemQty());
            record.setTotalValue(i.getTotalValue());
            if (invoice.getDeliveryType().toString().equalsIgnoreCase(AppConfigs.DELIVERY_TYPE_HOME_DELIVERY)) {
                record.setCity(invoice.getDeliveryAddress().getCity());
                record.setState(invoice.getDeliveryAddress().getState());
                record.setPinCode(invoice.getDeliveryAddress().getPinCode());
            }
            records.add(record);
        }
        return records;
    }

    /**
     * Set personally identifiable values to null
     *
     * @param invoice PosInvoice object
     * @return masked PosInvoice object
     */
    static PosInvoice getMaskedInvoice(PosInvoice invoice) {
        invoice.setCustomerCardNo(null);
        if (invoice.getDeliveryType().toString().equalsIgnoreCase(AppConfigs.DELIVERY_TYPE_HOME_DELIVERY)) {
            invoice.getDeliveryAddress().setAddressLine(null);
            invoice.getDeliveryAddress().setContactNumber(null);
        }
        return invoice;
    }

    /**
     * Transform PosInvoice to Notification
     *
     * @param invoice PosInvoice Object
     * @return Notification Object
     */
    static Notification getNotification(PosInvoice invoice) {
        Notification record = new Notification();
        record.setInvoiceNumber(invoice.getInvoiceNumber());
        record.setCustomerCardNo(invoice.getCustomerCardNo());
        record.setTotalAmount(invoice.getTotalAmount());
        record.setEarnedLoyaltyPoints(invoice.getTotalAmount() * AppConfigs.LOYALTY_FACTOR);
        return record;
    }
}