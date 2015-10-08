package TextGame;

public class Exit {

		public static final int undefined = 0;
		public static final int north = 1;
		public static final int south = 2;
		public static final int east  = 3;
		public static final int west  = 4;
		public static final int up    = 5;
		public static final int down  = 6;
		public static final int northeast = 7;
		public static final int northwest = 8;
		public static final int southeast = 9;
		public static final int southwest = 10;
		public static final int in = 11;
		public static final int out = 12;
		public static final int special = 13;

		public static final String[] dirName = {"undefined","north","south","east","west","up","down","northeast","northwest","southeast","southwest","in","out", "special"};

		public static final String[] shortDirName = {"null","n","s","e","w","u","d","ne","nw","se","sw","i","o", "sp"};

		private Location m_leadsTo = null;
		private int m_direction;

		private String m_directionName;

		private String m_shortDirectionName;

		public Exit(){
			m_direction = Exit.undefined;
			m_leadsTo = null;
			m_directionName = dirName[undefined];
			m_shortDirectionName = shortDirName[undefined];
		}

		public Exit( int direction, Location leadsTo ){
			m_direction = direction;

			if (direction <= dirName.length )
				m_directionName = dirName[m_direction];
			if (direction <= shortDirName.length )
				m_shortDirectionName = shortDirName[m_direction];

			m_leadsTo = leadsTo;
		}

		public String toString(){
			return m_directionName;
		}

		public void setDirectionName( String dirname ){
			m_directionName = dirname;
		}

		public String getDirectionName(){
			return m_directionName;
		}

		
		public void setShortDirectionName ( String shortName ){
			m_shortDirectionName = shortName;
		}

		public String getShortDirectionName (){
			return m_shortDirectionName;
		}

		public void setLeadsTo ( Location leadsTo ){
			m_leadsTo = leadsTo;
		}

		public Location getLeadsTo (){
			return m_leadsTo;
		}

	}

