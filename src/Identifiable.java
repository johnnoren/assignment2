public interface Identifiable {
	Name getName();

	IdentityNumber getIdentityNumber();
}


/*
PaymentViewable
Chargeable
Refundable
PaymentHistoryLookupable

*/


// TODO A member is someone who has paid for membership at some point. So it would perhaps make sense that a customer
// TODO has a membership and that the membership has a payment date. Don't waste too much time on this, I need to have
// TODO everything done before wednesday and I need time for renovation and other stuff!! DON'T TRY TO WRITE PERFECT
// TODO CODE!!! I will become better with time. I ALSO DON'T NEED TO HAVE INTERFACES FOR ALL METHODS!

// TODO should probably make a member interface that combines other interfaces and then make a member implementation.