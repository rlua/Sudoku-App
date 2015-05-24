package com.example.myfirstapp;

public class SudokuSolver {
    //static final String[] sudoku_numbers={"X","1","2","3","4","5","6","7","8","9"};
    //62,**, solved
//  static final int[][] inputmatrix=
//  {
//	{0,0,0,0,0,0,1,0,0},
//	{0,0,0,0,5,8,0,0,0},
//	{0,0,0,6,9,0,2,7,4},
//	{0,0,9,1,0,0,0,0,0},
//	{0,4,2,0,0,0,6,0,0},
//	{0,7,0,0,0,0,9,5,0},
//	{5,0,3,0,2,6,4,0,0},
//	{0,0,1,0,0,5,0,3,0},
//	{0,0,6,0,0,0,0,0,0},
//  };
  //64,** solved
//  static final int[][] inputmatrix=
//  {
//	{0,0,0,0,0,0,7,0,8},
//      {0,0,0,0,9,1,3,0,4},                	
//      {0,0,0,0,3,0,0,2,6},
//	{0,7,0,0,0,0,6,0,0},
//      {2,0,3,6,0,5,9,0,7},                	
//      {0,0,6,0,0,0,0,1,0},
//	{7,1,0,0,8,0,0,0,0},
//      {5,0,4,9,2,0,0,0,0},                	
//      {3,0,2,0,0,0,0,0,0},
//  };
  //70,** solved
//  static final int[][] inputmatrix=
//  {
//      {0,0,0,0,0,0,0,0,0},
//      {0,0,0,0,0,5,9,6,0},
//      {0,0,4,0,8,3,5,0,2},
//      {0,0,0,0,5,0,0,0,0},
//      {0,0,5,8,4,1,7,0,0},
//      {0,1,8,0,3,9,0,0,0},
//      {0,9,6,0,2,0,8,0,5},
//      {0,7,0,0,0,0,0,0,4},
//      {0,0,1,0,0,0,3,9,0},
//  };
  //72,*** solved
//  static final int[][] inputmatrix=
//  {
//	{0,0,0,0,0,0,4,0,7},
//      {0,0,0,0,0,0,6,0,0},                	
//      {0,0,7,0,0,3,9,2,8},
//	{0,0,6,0,2,4,7,0,0},
//      {0,0,0,5,0,9,0,0,0},                	
//      {8,3,0,0,6,0,0,0,0},
//	{0,9,0,0,0,1,8,0,0},
//      {7,0,3,2,0,0,0,0,0},
//      {0,5,0,6,0,0,0,0,0},
//  };
  //99, *** solved
//  static final int[][] inputmatrix=
//  {
//	{0,0,0,1,0,8,0,0,0},
//      {7,0,0,0,0,0,0,0,4},                	
//      {0,1,0,0,0,0,0,8,0},
//	{4,0,5,0,0,0,7,0,3},
//      {0,0,0,4,9,5,0,0,0},                	
//      {0,0,0,0,0,0,0,0,0},
//	{0,2,6,0,0,0,1,4,0},
//      {3,0,0,5,0,6,0,0,2},
//      {0,8,7,0,2,0,6,3,0},
//  };
  //100,***
//  static final int[][] inputmatrix=
//  {
//	{0,0,0,0,0,0,0,1,0},
//      {0,0,5,0,0,0,0,0,3},                	
//      {0,9,0,3,6,1,5,0,4},
//	{0,0,3,0,1,0,8,0,0},
//      {0,0,4,5,0,6,0,0,0},                	
//      {0,0,2,0,8,0,3,0,1},
//	{0,0,6,9,0,8,0,0,0},
//      {5,0,0,0,0,0,0,0,9},                	
//      {0,4,9,0,0,7,0,3,0},
//  };

  //Puzzle from a Vancouver newspaper
  static final int[][] inputmatrix=
  {
	{6,7,1,0,0,8,3,5,0},
      {0,0,8,1,0,0,7,0,0},                	
      {2,0,0,6,0,0,1,8,0},
	{0,6,2,9,5,0,8,4,1},
      {8,0,9,0,0,1,5,0,0},                	
      {1,0,0,0,8,6,2,9,0},
	{0,1,7,0,6,4,9,0,8}, //column 3 ("7") was a guess
      {4,2,3,8,1,9,6,7,5},
      {9,8,6,5,0,0,4,1,0},
  };

  //blanks
//  static final int[][] inputmatrix=
//  {
//	{0,0,0,0,0,0,0,0,0},
//      {0,0,0,0,0,0,0,0,0},                	
//      {0,0,0,0,0,0,0,0,0},
//	{0,0,0,0,0,0,0,0,0},
//      {0,0,0,0,0,0,0,0,0},                	
//      {0,0,0,0,0,0,0,0,0},
//	{0,0,0,0,0,0,0,0,0},
//      {0,0,0,0,0,0,0,0,0},
//      {0,0,0,0,0,0,0,0,0},
//  };
  
  //static class BL implements ActionListener
  //{
	int[][] _matrix=new int[9][9]; //The current incomplete solution

      //Last array index used to mark numbers that are not possible.
      int[][][] _impmatrix=new int[9][9][9];
      void set_impmatrix()
      {
          for(int i=0;i<9;i++)
          {
              for(int j=0;j<9;j++)
              {
                  for(int k=0;k<9;k++)
                  {
                      _impmatrix[i][j][k]=0;
                  }
              }
          }
      }
      void scan_impmatrix()
      {
          for(int i=0;i<9;i++)
          {
              for(int j=0;j<9;j++)
              {
                  int numpossible=0,value=-1;
                  for(int k=0;k<9;k++)
                  {
                      if(_impmatrix[i][j][k]==0)
                      {
                          value=k;
                          numpossible++;
                      }
                  }
                  if(numpossible==1)
                  {
                      _matrix[i][j]=value+1;
                  }
              }
          }
      }
      
      int[][] _tmpmatrix=new int[9][9]; //The current solution with unsolved cells marked if they cannot be occupied by the currently examined number.
/*	//JTextField[][] _jta;
      JComboBox[][] _jta;

	//BL(JTextField[][] jta)
      BL(JComboBox[][] jta)
	{
	    _jta=jta;
	}*/

	void initmatrix(int values[][])
	{
	    for(int i=0;i<9;i++)
		{
		    for(int j=0;j<9;j++)
			{
			    try
				{
				    //_matrix[i][j]=Integer.parseInt(_jta[i][j].getText());
                                  //_matrix[i][j]=_jta[i][j].getSelectedIndex();
			    	_matrix[i][j]=values[i][j];
				}
			    catch(NumberFormatException ne)
				{
				    _matrix[i][j]=0;
				}
			}
		}
	}

	void updateTextFields()
	{
	    for(int i=0;i<9;i++)
		{
		    for(int j=0;j<9;j++)
			{
			    //_jta[i][j].setText(""+_matrix[i][j]+"");
                         // _jta[i][j].setSelectedIndex(_matrix[i][j]);
			}
		}
	}
	
	public int getCellValue(int i, int j)
	{
		return _matrix[i][j];
	}

	void settmpmatrix()
	{
	    for(int i=0;i<9;i++)
		{
		    for(int j=0;j<9;j++)
			{
			    _tmpmatrix[i][j]=_matrix[i][j];
			}
		}
	}

	boolean isIncomplete()
	{
	    for(int i=0;i<9;i++)
		{
		    for(int j=0;j<9;j++)
			{
			    if(_matrix[i][j]<1)
				{
				    return true;
				}
			}
		}
	    return false;
	}

	void markVertical(int col , int n)
	{
	    for(int i=0;i<9;i++)
		{
		    if(_matrix[i][col]==0) //cannot be occupied
			{
			    _tmpmatrix[i][col]=-1;
                          _impmatrix[i][col][n-1]=1;
			}
		}
	}

	void markHorizontal(int row, int n)
	{
	    for(int i=0;i<9;i++)
		{
		    if(_matrix[row][i]==0) //cannot be occupied
			{
			    _tmpmatrix[row][i]=-1;
                          _impmatrix[row][i][n-1]=1;
			}
		}
	}

	void markSquare(int row, int col, int n)
	{
	    int srow=3*(row/3),
		scol=3*(col/3);
	    //Check 3x3 region
	    for(int i=0;i<3;i++)
		{
		    for(int j=0;j<3;j++)
			{
			    if(_matrix[srow+i][scol+j]==0)
				{
				    _tmpmatrix[srow+i][scol+j]=-1;
                                  _impmatrix[srow+i][scol+j][n-1]=1;
				}
			}
		}
	}

	void mark(int n)
	{
	    for(int i=0;i<9;i++)
              {
		    for(int j=0;j<9;j++)
			{
			    if(_matrix[i][j]==n)
				{
				    markVertical(j,n);
				    markHorizontal(i,n);
				    markSquare(i,j,n);
				}
			}
		}
	}

	boolean isLoneVoidHorizontal(int row, int col)
	{
	    for(int i=0;i<9;i++)
		{
		    if(i==col)
			continue;
		    if(_tmpmatrix[row][i]==0)
			{
			    return false;
			}
		}
	    return true;
	}

	boolean isLoneVoidVertical(int row, int col)
	{
	    for(int i=0;i<9;i++)
		{
		    if(i==row)
			continue;
		    if(_tmpmatrix[i][col]==0)
			{
			    return false;
			}
		}
	    return true;
	}

	boolean isLoneVoidSquare(int row, int col)
	{
	    int srow=3*(row/3),
		scol=3*(col/3);
	    //Check 3x3 region
	    for(int i=0;i<3;i++)
		{
		    for(int j=0;j<3;j++)
			{
			    if(srow+i==row && scol+j==col)
				continue;
			    if(_tmpmatrix[srow+i][scol+j]==0)
				{
				    return false;
				}
			}
		}
	    return true;
	}

	void fillLoneVoid(int n)
	{
	    for(int i=0;i<9;i++)
		{
		    for(int j=0;j<9;j++)
			{
			    if(_tmpmatrix[i][j]==0)
				{
				    if(isLoneVoidVertical(i,j) ||
				       isLoneVoidHorizontal(i,j) ||
				       isLoneVoidSquare(i,j))
					_matrix[i][j]=n;
				}
			}
		}
      }

              //YVR 01/17/09
              //This is a weak verification (checksum)
              void isCorrect()
              {
                  //Check vertical and horizontal totals
                  int errors=0;
                  for(int i=0;i<9;i++)
                  {
                      int sum=0;
                      for(int j=0;j<9;j++)
                      {
                          sum+=_matrix[i][j];
                      }
                      if(sum!=45)
                      {
                          errors++;
                      }
                  }
                  for(int i=0;i<9;i++)
                  {
                      int sum=0;
                      for(int j=0;j<9;j++)
                      {
                          sum+=_matrix[j][i];
                      }
                      if(sum!=45)
                      {
                          errors++;
                      }
                  }
                  
                  //Check 3x3 region
                  for(int srow=0;srow<=6;srow+=3)
                      for(int scol=0;scol<=6;scol+=3)
                      {
                          int sum=0;
                          for(int i=0;i<3;i++)
                              {
                                  for(int j=0;j<3;j++)
                                      {
                                          sum+=_matrix[srow+i][scol+j];
                                      }
                              }
                          if(sum!=45)
                          {
                              errors++;
                          }
                      }

                  if(errors==0)
                  {
                      System.out.println("Solution correct");
                  }
                  else
                  {
                      System.out.println("Solution incorrect");
                  }
              }

	public void Solve(int values[][])
	{
	    initmatrix(values);
          set_impmatrix();
	    int maxiter=10000;
	    while(isIncomplete())
		{
		    if(maxiter--<1)
			break;
		    for(int n=1;n<=9;n++)
			{
			    settmpmatrix();
			    mark(n);
			    fillLoneVoid(n);
                          scan_impmatrix();
			}
		}
	    //updateTextFields();
          isCorrect(); //YVR 01/17/09
	}
  //}

	/**
	 * The entry point for the applet. 
	 */
	

/*  public void init()
  {
	Container ct = getContentPane();
	JPanel jp=new JPanel();
	jp.setLayout(new GridLayout(9,9));
	//JTextField[][] jtArray=new JTextField[9][9];
      JComboBox[][] jtArray=new JComboBox[9][9];

	JButton jb=new JButton("Solve");
	jb.addActionListener(new BL(jtArray));

	ct.add(jb, BorderLayout.NORTH);
	ct.add(jp, BorderLayout.CENTER);

	for(int i=0;i<9;i++)
	    {
		for(int j=0;j<9;j++)
		    {
			//JTextField jtmp=new JTextField(""+inputmatrix[i][j]+"");
                      JComboBox jtmp=new JComboBox(sudoku_numbers);
                      jtmp.setSelectedIndex(inputmatrix[i][j]);
			jtArray[i][j]=jtmp;
			if((i/3)%2==0 && (j/3)%2==0)
			    jtmp.setBackground(Color.RED);
			else if((i/3)%2==1 && (j/3)%2==1)
			    jtmp.setBackground(Color.RED);
			else
			    jtmp.setBackground(Color.WHITE);
			jp.add(jtmp);
		    }
	    }
  }*/

  //Changed TextField to JComboBox. 06/01/09.
  /*public static void main(String[] args)
  {
	JFrame jf=new JFrame("Sudoku solver");
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JSudoku js=new JSudoku();
      js.init();
      
      jf.add(js);
	jf.pack();
	jf.show();
      
  }*/
}
