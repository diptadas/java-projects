package com.example;

public class PlayingCard {

	private Suit suit;
	private int rank;

	public PlayingCard()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayingCard(Suit suit, int rank)
	{
		super();
		this.suit = suit;
		this.rank = rank;
	}

	public void getSuitName()
	{
		switch (suit)
		{
		case SPADES:
			System.out.println("Card Is Spades");
			break;
		case HEARTS:
			System.out.println("Card Is Hearts");
			break;
		case CLUBS:
			System.out.println("Card Is Clubs");
			break;
		case DIAMONDS:
			System.out.println("Card Is Diamonds");
			break;
		}
	}

	@Override
	public String toString()
	{
		return "PlayingCard [suit=" + suit + ", rank=" + rank + "]";
	}

}
