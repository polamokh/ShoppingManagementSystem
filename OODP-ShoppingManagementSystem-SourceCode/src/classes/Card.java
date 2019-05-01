package classes;


public abstract class Card implements Payment_method
{
    private  String Name_on_Card;
    private  String Number;
    private  String CVV;
    private  String Expiration_Date;
    
    public Card(String nameOnCard, String number, String cvv, String expirationDate)
    {
        setName_on_Card(nameOnCard);
        setNumber(number);
        setCVV(cvv);
        setExpiration_Date(expirationDate);
    }
   

	public String getName_on_Card() {
		return Name_on_Card;
	}

	public void setName_on_Card(String name_on_Card) {
		Name_on_Card = name_on_Card;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getCVV() {
		return CVV;
	}

	public void setCVV(String cVV) {
		CVV = cVV;
	}

	public String getExpiration_Date() {
		return Expiration_Date;
	}

	public void setExpiration_Date(String expiration_Date) {
		Expiration_Date = expiration_Date;
	}

    @Override
    public void pay(int money) {
        System.out.println(money + "paid with debit/credit card" );
    }
	}
    
