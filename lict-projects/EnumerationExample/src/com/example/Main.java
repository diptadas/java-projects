package com.example;

public class Main {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		PlayingCard card = new PlayingCard(Suit.SPADES, 2);
		card.getSuitName();
		System.out.println(card);

		ColorFactory factory = new ColorFactory(Color.R);
		System.out.println("Color code: " + factory.getColor().getColorCode());
		System.out.println("Color rank: " + factory.getColor().getRank());
	}

}
