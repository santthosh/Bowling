package com.inmobi.bowling;

public class Scorer
{
  public void addThrow(int pins)
  {
    itsThrows[itsCurrentThrow++] = pins;
  }

  public int scoreForFrame(int theFrame)
  {
    ball = 0;
    int score=0;
    for (int currentFrame = 0; 
         currentFrame < theFrame; 
         currentFrame++)
    {
      if (strike())
        score += 10 + nextTwoBalls();
      else if (spare())
        score += 10 + nextBall();
      else
        score += twoBallsInFrame();
    }

    return score;
  }

  private boolean strike()
  {
    if (itsThrows[ball] == 10)
    {
      ball++;
      return true;
    }
    return false;
  }

  private boolean spare()
  {
    if ((itsThrows[ball] + itsThrows[ball+1]) == 10)
    {
      ball += 2;
      return true;
    }
    return false;
  }

  private int nextTwoBalls()
  {
    return itsThrows[ball] + itsThrows[ball+1];
  }

  private int nextBall()
  {
    return itsThrows[ball];
  }

  private int twoBallsInFrame()
  {
    return itsThrows[ball++] + itsThrows[ball++];
  }

  private int ball;
  private int[] itsThrows = new int[21];
  private int itsCurrentThrow = 0;
}