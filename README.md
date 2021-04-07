목차
  + [기본 문법](#기본-문법)


# 기본 문법
<details>
  <summary> 목록 </summary>

  <details>
    <summary> 로그 </summary>
    <br/>  

  - 종류
    |종류|의미|내용|
    |--|--|--|
    |Log.v()|verbose|상세 로그 내용 출력|
    |Log.i()|information|개발에 필요한 내용을 출력|
    |Log.d()|debug|정보성의 일반적 메시지 전달|
    |Log.w()|warning|경고성 메시지 전달|
    |Log.e()|error|실제 에러 메시지 출력|

  - 사용법
    ~~~
      Log.v("태그", "출력메시지")
      Log.i("태그", "출력메시지")
      Log.d("태그", "출력메시지")
      Log.w("태그", "출력메시지")
      Log.e("태그", "출력메시지")
    ~~~
  </details>





















  <details>
    <summary> 변수, 상수 </summary>
    <br/>  

  - var
    + 변수 : 값을 임시로 메모리에 저장하고, 저장 공간에 이름을 부여한 것
    + 선언 및 사용방법
      |선언 방법|사용방법|
      |--|--|
      |변수 선언과 동시에 값 넣기|var 변수명 = 값|
      |값으로 초기화 하지 않고 선언만하고 사용|var 변수명 : 타입 <br/> 변수명 = 값|
    + 데이터 타입
      | 구분 | 데이터 타입 | 설명 | 값의 범위 및 예 |
      | -- | -- | -- | -- |
      | 숫자형 | Double | 64비트 실수 | -1.7E+308 근사값 ~ 1.7E+308 근사값 |
      | 숫자형 | Float | 32비트 실수 | -3.4E+38 근사값 ~ 3.4E+38 근사값 |
      | 숫자형 | Long | 64비트 실수 | -2E63 ~ 2E63 - 1 |
      | 숫자형 | Int | 32비트 실수 | -2147483648 ~ 2147483647 |
      | 숫자형 | Short | 16비트 실수 | -32768 ~ 32767 |
      | 숫자형 | Byte | 8비트 실수 | -128 ~ 127 |
      | 문자형 | Char | 1개의 문자 | '글' |
      | 문자형 | String | 여러 개의 문자 | "여러 문자" |
      | 불린형 | Boolean | true, false 두 가지 값 | true or false |

  - val
    + 상수 : 한 번 입력된 값은 변경할 수 없고, 기준이 되는 변하지 않는 값을 미리 입력할 때 사용
    + 선언 및 사용방법은 변수와 동일하다.

  - String 템플릿
    + 더하기 연산으로 2개의 문자를 하나로 합칠 수 있다. 
    + 문자열 내부에서 $기호를 넣으면 해당 영역이 문자가 아닌 코드라는 것을 알려줌(뒤에 공백)
    + 문자열 내부에서 {}와 $를 사용하여 추가적인 수식을 입력할 수도   
    + dropLast를 사용하면 끝 한단어가 삭제됨
    + Spannable을 통해 텍스트의 '일부' 에만 색을 입히거나, 크기를 늘리거나 등등 효과를 넣을 수 있게 해줌
      + 입력받았을때 기준 뒤에 한자리가 연산자이기에 이렇게 설정
      + 마지막 요소는 앞뒤로 색을 더 적용할 것인가 의미
      ~~~
        val ssb = SpannableStringBuilder(expressionTextView.text)
        ssb.setSpan(
            ForegroundColorSpan(getColor(R.color.green)),
            expressionTextView.text.length - 1,
            expressionTextView.text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
      ~~~
      
  - BigInteger
  -    
  </details>












  <details>
    <summary> 조건문 </summary>
    <br/>  
  
  * 언제 if, when을 사용하는가
    - if : 범위가 넓고 값을 특정할 수 없는 경우
    - when : 범위가 제한되고 값도 특정할 수 있는 경우
  
  * if
    - if 사용 조건
      1. 조건식에는 비교 연산자(==, <, >)와 논리 연산자(&&, ||)만을 사용 가능
      2. 조건식의 결과는 Boolean 타입
    - if else
      ~~~
        if (조건식) {
            조건식이 참인 경우 실행
        } else {
            조건식이 거짓인 경우 실행
        }
      ~~~
    - if ~ , else if ~, else
      ~~~
        if (조건식1) {
            조건식1이 참인 경우 실행
        } else if (조건식2) {
            조건식1이 거짓이고, 조건식 2가 참인 경우 실행
        } else {
            조건식1, 조건식2 모두 거짓인 경우 실행
        }
      ~~~
    - 변수에 직접 if 사용
      ~~~
        var a = 5
        var b = 3
        var bigger = if (a>b) a else b
      ~~~
    - if 마지막 값을 반환 값으로 사용
      ~~~
        var a = 5
        var b = 3
        var bigger = if (a>b) {
            a = a - b
            a 
        }
      ~~~
    
  * when
    - 일반적 사용
      ~~~
        when (파라미터) {
            비교값1 -> {
                변숫값이 비교값과 같다면 이 부분이 실행됨
            }
            비교값2 -> {
                변숫값이 비교값과 같다면 이 부분이 실행됨
            }
            비교값3 -> {
                변숫값이 비교값과 같다면 이 부분이 실행됨
            }
        }
      ~~~
    - 콤마로 구분해서 사용
      ~~~
        특정 값을 비교하는데 결과 처리가 동일하다면, 콤마로 구분하여 한번에 비교 가능
        
        when (파라미터) {
            비교값1, 비교값2 -> {
                변숫값이 비교값1 혹은 비교값2과 같다면 이 부분이 실행됨
            }
            else -> {
                그 밖의 경우 실행
            }
        }
      ~~~
    - 범위 값을 비교
      ~~~
        in을 사용해서 범위 값을 비교할 수 있음. 
        if문의 비교연산자 중 <=, >=과 같은 기능을 구현할수도 있음.
        
        when (파라미터) {
            in 비교값n .. 비교값m -> {
                변숫값이 비교값n 부터 비교값m 사이에 속하는 경우 이 부분이 실행됨
            }
            !in 비교값n .. 비교값m -> {
                변숫값이 비교값n 부터 비교값m 사이에 속하지 않는 경우 이 부분이 실행됨
            }
            else {
                나머지 경우 이 부분이 실행됨
            }
        }
      ~~~
    - 파라미터 없는 when
      ~~~
        when 다음에 오는 괄호를 생략하고 마치 if문처럼 사용할 수 있음
        
        when {
            A == 5 -> {
                조건이 참일 때 실행
            }
            A > 5 -> {
                조건이 참일 때 실행
            }
            else {
                조건이 참일 때 실행
            }
        }
      ~~~

  </details>













  <details>
    <summary> 반복문 </summary>
    <br/>
  
  * for
    - for in ..
    - until
    - step
    - downTo
    - 배열, 컬렉션에 들어있는 요소만큼 반복
  
  * while
    - 일반적인 while
    - do와 함께 사용
    - do ~ while
    
  * 반복문 제어
    - break
    - continue
    
  </details>
















  <details>
    <summary> 클래스 </summary>
    <br/>  
  </details>












  <details>
    <summary> 함수 </summary>
    <br/>
  
  * 리턴
    - try catch를 이용한 반환
      + 이것처럼 try catch를 이용한 결과도 가능
      + 이때 BigInteger는 범위가 방대한 인티저임
    ~~~
      fun String.isNumber(): Boolean {
          return try {
              this.toBigInteger()
              true
          } catch (e: NumberFormatException) {
              false
          }
      }
    ~~~
  </details>













  <details>
    <summary> 주석 </summary>
    <br/>  

  - 주석 및 설명
    | 주석 종류  | 설명 |
    | -- | -- |
    | // | 한줄을 주석 처리할 때 사용 |
    | /* */ | 여러줄을 주석  | 
    | /** */ | 문서화할 주석을 작성할 때 |

  </details>



















  <details>
    <summary> 배열과 컬렉션 </summary>
    <br/>  

  * 배열(Array)
    - 설명
      + 값을 담기 전에, 배열 공간의 개수를 할당하거나 초기화 시에 데이터를 저장해두면 데이터의 개수만큼 배열의 크기 결정
      + 먼저 개수를 정해놓고 사용해야 함
      + 중간에 개수를 추가하거나 제거할 수 없음

    - 선언하기
      ~~~
        var 변수 = Array(개수)
        ex)
        var students = IntArray(10)
        var longArray = LongArray(10)
      ~~~

    - 문자 배열에 빈 공간 할당하기
      ~~~
        var stringArray = Array(10, {item->""})
      ~~~

    - 값으로 배열 공간 할당하기
       ~~~
          var dayArray = arrayOf("MON", "THU", "WED", "THU", "FRI", "SAT", "SUN")
       ~~~

    - 배열에 값 입력하기
      ~~~
        1. 배열명[인덱스] = 값
        2. 배열명.set(인덱스, 값)
      ~~~

    - 배열에 있는 값 꺼내기 
      ~~~
        1. 배열명[인덱스]
        2. 배열명.get(인덱스)
      ~~~

  * 컬렉션(Collection)
    - 리스트 
      - 설명
        + 저장되는 데이터에 인덱스를 부여한 컬렉션
        + 중복된 값을 입력할 수 있다
        + 동적으로 사용하기 위해선, 리스트 자료형 앞에 Mutable이라는 접두어가 붙는다
      - 리스트 생성하기 : mutableListOf
        ~~~
          var list = mutableListOf("Mon", "Thu", "Wed")
        ~~~
      - 리스트에 값 추가하기 : add
        ~~~
          mutableList.add("~")
        ~~~
      - 리스트에 입력된 값 사용하기 : get
        ~~~
          인덱스를 지정하여 몇번째 값을 꺼낼 것인지 명시
          
          var variable = mutableList.get(1)
        ~~~
      - 리스트값 수정하기 : set
        ~~~
          특정 인덱스 값을 수정
          
          mutableList.set(1, "수정할 값")
        ~~~
      - 리스트에 입력된 값 제거하기 : removeAt
        ~~~
          리스트에 입력된 값의 인덱스를 지정하여 삭제
          
          mutableList.removeAt(1)
        ~~~
      - 빈 리스트 사용하기
        ~~~
          빈 컬렉션의 경우, 데이터 타입으 직접적으로 알려주는 방법을 사용
          
          var 변수명 = mutableListOf<타입>()
        ~~~
    - 컬렉션 개수 가져오기 : size
      ~~~
        mutableList.size
      ~~~
    - 셋
      - 설명
        + 중복을 허용하지 않는 리스트
        + 인덱스로 조회할 수 없고, get도 지원하지 않음
        + 사용법 
          ~~~
            var set = mutableSetOf<String>()
          ~~~
      - 빈 셋으로 초기화하고 값 입력하기
        ~~~
          중복되는 요소를 추가시, 추가되지 않음
          
          set.add("~~")
        ~~~
      - 셋 사용하기
        ~~~
          인덱스로 조회하는 함수가 없어, 특정 위치 값을 직접 이용 불가
          
          ${set}을 할경우, set의 모든 값을 나타냄 - 출력문에서
        ~~~
      - 셋 삭제하기
        ~~~
          값이 중복되지 않아, 값으로 직접 조회 후 삭제 가능
          
          set.remove("value")
        ~~~
    - 맵
      - 설명
        + 키와 값의 쌍으로 입력되는 컬렉션
        + 키는 리스트의 인덱스와 비슷하지만, 리스트와 다르게 직접 입력해야 한다
        
      - 맵 생성하기
        ~~~
          var map = mutableMapOf<String, String>()
        ~~~
      - 빈 맵으로 생성하고 값 추가하기
        ~~~
          map.put("key", "value")
        ~~~
      - 맵 사용하기
        ~~~
          map.get("key")
        ~~~
      - 맵 수정하기
        ~~~
          put 함수를 사용할 때, 동일한 키 값이 있으면 키 값은 유지하고 값만 수정
          
          map.put("key", "value2")
        ~~~
      - 맵 삭제하기
        ~~~
          삭제한 인덱스는 사라지지 않고 유지됨
          
          map.remove("key")
        ~~~

  * 이뮤터블 컬렉션
    - 설명
      + 일반 배열처럼 크기를 변경할 수 없고, 값 또한 변경할 수 없음
      + 기존 컬렉션에서 mutable이라는 접두어가 제거된 형태로 사용
      + 기준이 되는 어떤 값의 모음을 하나에 저장할 때 OR 여러 개의 값을 중간에 수정하지 않고 사용할 필요가 있을 때 사용
    - 사용법
      ~~~
        var list = listOf("1", "2")
      ~~~
  </details>
</details>
















  <details>
    <summary> DB </summary>
    <br/>  
  
  * DB 사용하기
    - 앱 그래들 추가
      + 플러그인
        ~~~
          plugins {
              id 'com.android.application'
              id 'kotlin-android'
              id 'kotlin-kapt'
          }
        ~~~
      + 라이브러리(defendencies)
        ~~~
             kapt "androidx.room:room-compiler:2.2.6"     
             implementation "androidx.room:room-runtime:2.2.6"
        ~~~
    - DB 엔티티 모델(테이블) 선언
      ~~~
        package fastcampus.aop.part2.chapter4.model

        import androidx.room.ColumnInfo
        import androidx.room.Entity
        import androidx.room.PrimaryKey

        @Entity
        data class History(
            @PrimaryKey val uid: Int?,
            @ColumnInfo(name = "expression") val expression: String?,
            @ColumnInfo(name = "result") val result: String?
        )
      ~~~
    - 테이블 조작 방식 정의(인터페이스)
      ~~~
        package fastcampus.aop.part2.chapter4.dao

        import androidx.room.Dao
        import androidx.room.Delete
        import androidx.room.Insert
        import androidx.room.Query
        import fastcampus.aop.part2.chapter4.model.History

        @Dao
        interface HistoryDao {

            @Query("SELECT * FROM history")
            fun getAll(): List<History>

            @Insert
            fun insertHistory(history: History)

            @Query("DELETE FROM history")
            fun deleteAll()

        //    @Delete
        //    fun delete(history: History)
        //
        //    @Query("SELECT * FROM history Where result LIKE :result LIMIT 1")
        //    fun findByResult(result: String):History
        }
      ~~~
    - 실제 클래스로써 이용할 수 있게 추상 클래스로 생성
      ~~~
        package fastcampus.aop.part2.chapter4

        import androidx.room.Database
        import androidx.room.RoomDatabase
        import fastcampus.aop.part2.chapter4.dao.HistoryDao
        import fastcampus.aop.part2.chapter4.model.History

        @Database(entities = [History::class], version = 1)
        abstract class AppDatabase : RoomDatabase() {
            abstract fun historyDao(): HistoryDao
        }
      ~~~
    - 사용
      + 선언
        ~~~
          lateinit var db: AppDatabase
        ~~~
      + onCreate
        ~~~
          db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "historyDB"
          ).build()
        ~~~
      + DB 조작  
        ~~~
          Thread(Runnable {
              db.historyDao().insertHistory(History(null, expressionText, resultText))
          }).start()
          
          
          Thread(Runnable {
              db.historyDao().getAll().reversed().forEach {
                  runOnUiThread {
                      val historyView = LayoutInflater.from(this).inflate(R.layout.history_row, null, false)
                      historyView.findViewById<TextView>(R.id.expressionTextView).text = it.expression
                      historyView.findViewById<TextView>(R.id.resultTextView).text = "= ${it.result}"

                      historyLinearLayout.addView(historyView)
                  }
              }
        }).start()
        ~~~
  </details>














<details>
  <summary> 느낀점 </summary>
  
  * 코틀린
    - null safety
      코틀린은 자바와 완벽하게 호환하기 때문에, 코틀린에서 null safety 정책이 존재한다.
      ~~~
        자바에는 null이 올 수 있기 때문에 ?, !를 통해 언급해주는 것
      ~~~
      + lateinit
        ~~~
          var nullalbeNumber:Int? = null
          
          lateinit var lateinitNumber:Int
          
          lateinitNumber = 10
          
          사용시
          nullableNumber?.add()
          lateinitNumber.add()
        ~~~
      + lazy init
        ~~~
          val lazyNumber :Int by lazy {
              100
          }
          > 사용하기 전까지 할당되지 않음
          
          lazyNumber.add()
          > 사용함으로써, 100이 할당됨
        ~~~
  
    - Function Expression
      코틀린에서 함수를 좀더 편리하게 표현하는 방식이 존재한다.
      ~~~
        fun sum (a:Int, b:Int):Int {
            return a+b
        }
        
        ==
        
        fun sum (a:Int, b:Int) = a + b
        
        다음과 같이 사용할 수도 있다
        fun max(a:Int, b:Int) = if(a>b) a else b
      ~~~
  
    - 화면 가로로 하기
      + 매니페스트에서 가로로 설정할 수 있음
      ~~~
        <activity android:name=".PhotoFrameActivity"
            android:screenOrientation="landscape"
            />
      ~~~
  
  
  
  
  
  
  * 레이아웃
    - Constraint 레이아웃
      + 0dp를 주고 제약조건을 걸면 match처럼 양쪽이 최대로 늘어난다
      + 가중치를 주는 방법에는 제약조건 constraint 중 weight에 관련된 속성을 이용하는 법이 있다       
      ~~~
      <View
        android:id="@+id/topLayout"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintBottom_toTopOf="@id/keypadTableLayout"
        app:layout_constraintVertical_weight="1" />
      ~~~
    - Linear 레이아웃
      + removeAllViews()을 사용하면 해당 Linear에 있는 모든 뷰가 삭제됨
      + Linear에서 높이를 0으로 하고 가로와 세로간의 비율로 주는 설정하는 방법
        ~~~
            <LinearLayout
                android:id="@+id/firstRowLinearLayout"
                android:layout_width="0dp"
                android:layout_height="0dp"
                app:layout_constraintTop_toTopOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintDimensionRatio="H,3:1">
        ~~~

  * xml
    - xml에서 겹친 뷰들은 뒤쪽에 온게 더 앞쪽에 옴
    - ImageView
      + 이미지를 조절하는 방법을 설정하는 속성 : scaleType
        ~~~
        <ImageView
            android:id="@+id/imageView11"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:scaleType="centerCrop" />
        ~~~
      + URL로 이미지 설정
        ~~~
          photoImageView.setImageURI(photoList[next])
        ~~~
      + 애니메이션 주기
        ~~~
          photoImageView.animate()
            .alpha(1.0f)
            .setDuration(1000)
            .start()
        ~~~
        
    - ripple
      + 안드로이드 머터리얼 테마에서 지원하는 그리기 효과. 눌렀을때 물결처럼 촥 퍼지는 효과를 가지고 있음
      + ripple에서 color 속성은 눌렀을 떄 색이고, background는 item 태그를 통해 다시 설정해줘야 함     
      ~~~
        <ripple xmlns:android="http://schemas.android.com/apk/res/android"
            android:color="@color/buttonPressGray">

            <item android:id="@android:id/background">
                <shape android:shape="rectangle">
                    <solid android:color="@color/buttonGray" />
                    <corners android:radius="100dp" />
                    <stroke
                        android:width="1dp"
                        android:color="@color/buttonPressGray" />
                </shape>
            </item>
        </ripple>
      ~~~
    - 안드로이드 네임스페이스가 추가되어있지 않다면, android:color에 오류가 뜸
    
    - rentangle(다른 도형도 마찬가지)
      + 라운드 효과를 주고자 한다면 corner 속성을 추가하면 된다
      + shape 안에 solid 속성을 넣어야 색이 칠해짐
      + stroke 속성이 태두리를 설정함
        ~~~
          <ripple xmlns:android="http://schemas.android.com/apk/res/android"
              android:color="@color/buttonPressGray">

              <item android:id="@android:id/background">
                  <shape android:shape="rectangle">
                      <solid android:color="@color/buttonGray" />
                      <corners android:radius="100dp" />
                      <stroke
                          android:width="1dp"
                          android:color="@color/buttonPressGray" />
                  </shape>
              </item>
          </ripple>
        ~~~
    
    - stateListAnimator에 "@null"을 넣어 기본적으로 적용중인 애니메이션을 취소할 수 있음
    - 
  
  
  
  
  
  
  * 단축키(reformat code)
    
    코드 순서를 일관성있게 정리해줌
    ~~~
      Ctrl + Alt + L
    ~~~
  
  
  
  
  
  
  * 조건문
    
    - when
      when 파라미터의 조건식으로 자료형을 판단할 수 있음
      
      ~~~
        when(x) {
            is Int -> ~~~
            else -> ~~~
        }
      ~~~
  
  
  
  
  
  
  
  
  
  * Scope Function
    - apply
      자바와 비교하여 이해하기
      ~~~
        val person = Person().apply{
            firstName = "Fast"
            lastName = "Campus"
        }
        
        Person person = new Person();
        person.firstName = "Fast";
        person.lastName = "Campus";
        
        보통 초기화할 때 사용
      ~~~
    
    - with
      자바와 비교하여 이해하기
      ~~~
        val person = Person()
        
        with(person){
            work()
            sleep()
            println(age)
        }
        
        -------------------------
        
        Person person = new Person();
        
        person.work();
        person.sleep();
        System.out.print(person.age);
        
        하나의 객체를 중점으로 한번에 수행할 함수들을 묶음
      ~~~
    
    - let
      자바와 비교하여 이해하기
      ~~~
        #1
        val number:Int?
        
        val sumNumberStr = number?.let {
            "${sum(10, it}"
        }
        
        #2
        val number:Int?
        
        val sumNumberStr = number?.let {
            "${sum(10, it}"
        }.orEmpty()
        -----------------------------------
        #1
        Integer number = null;
        String sumNumberStr = null;
        
        if(number != null) {
            sumNumber = ""+sum(10,number);
        }
        
        #2
        Integer number = null;
        String sumNumberStr = null;
        
        if(number != null) {
            sumNumber = ""+sum(10,number);
        } else {
            sumNumber = "";
        }
      ~~~
    
    - also
      자바와 비교하여 이해하기
      ~~~
        Random.nextInt(100).also {
            print("getRandomInt() is $it")
        }
        
        int value = Random().nextInt(100);
        System.out.print(value);
        
        다수의 동작을 하나로 묶어서 수행시킬 수 있다
      ~~~
      
    - run
      자바와 비교하여 이해하기
      ~~~
        val result = service.run {
            port = 8080
            query()
        }
        
        -----------------------------
        
        service.port = 8080;
        Result result = service.query();
        
        with와 다르게 하나의 객체를 중점으로 수행하지 않음
      ~~~
  
  * 텍스트 처리

    하나하나 타이핑해서 넣기보다 values의 string을 이용해서 코딩하면, 하나를 수정하면 전체가 반영되기에 유지보수에 유리하다
    ~~~
      <Button
          android:id="@+id/clearButton"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:text="@string/clear"
    ~~~
  
  * findViewById()
    
    과거 코틀린은 익스텐션을 통해 findViewById를 생략할 수 있도록 해줬으나, 익스텐션에 에러가 많아서 지원 안하게 됨
    ~~~
      val heightEditText: EditText = findViewById(R.id.heightEditText)
      val weightEditText = findViewById<EditText>(R.id.weightEditText)
    ~~~
    
  * 액티비티 추가
  
    액티비티를 추가할 때마다 매니페스트에 추가해야됨
    ~~~
      <activity android:name=".ResultActivity"/>
    ~~~
    
 
 
 
 
 
 
 
 
  * 예외처리
    
    리스너 안에서 예외처리를 할 때 return 값으로 해당 리스너를 반환해줌으로써, 어디에서 예외가 났는지 알 수 있게 해줌
    
    ~~~
       resultButton.setOnClickListener {

            if (heightEditText.text.isEmpty() || weightEditText.text.isEmpty()) {
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
    ~~~
    
  
  
  
  
  
  
  
  
  
  * 인텐트
  
    전달받은 intent를 받을 때, 별도의 getIntent()없이 바로 사용할 수 있음
    
    ~~~
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_result)

          val height = intent.getIntExtra("height", 0)
          val weight = intent.getIntExtra("weight", 0)
    ~~~
    








  * theme (in values)
    - 해당 프로젝트에 들어가는 위젯들의 기본적인 색이나 모양들을 미리 선언해둔 것
    - 영향을 받지 않으려면 theme에서 설정해주거나, Appcompat 접두어가 붙은 위젯들을 사용한다
    - theme에서 NoActionBar를 설정해주고, 메니페스트에서 해당값을 사용하면 앱의 상단 액션바가 없어진다
      ~~~
            <style name="AppTheme.NoActionBar" parent="Theme.MaterialComponents.DayNight.NoActionBar"/>
          
            <activity android:name=".MainActivity"
            android:theme="@style/AppTheme.NoActionBar">
      ~~~
  
 
 
 
 
  * getSharedPreferences
    - getSharedPreferences도 Map처럼 객체 이름, 키와 밸류로 이루어져 있다.
    - getSharedPreferences에서 해당 파일을 다른 앱과 공유하고 싶지 않을 떈 private으로 설정해주면 된다.
      ~~~
          val sharedPreferences = getSharedPreferences("password", Context.MODE_PRIVATE)
      ~~~
  
  
  
  
  
  
  
  
  
  * 람다식
    - 람다식을 넘길 때 보통 인자가 1개일때는 생략할 수 있으나, 2개 이상인 경우 명시가 필요하다.
    - 2개 이상의 인자가 요구되지만, 사용되지 않는다면 언더바로 바꿔서 넘길 수 있다
      ~~~
        private fun showErrorPopup() {
        AlertDialog.Builder(this)
            .setTitle("실패")
            .setMessage("비밀번호가 잘못되었습니다.")
            .setPositiveButton("확인") {dialog, which -> ~~~~ }
            .create()
            .show()
        }
        
        private fun showErrorPopup() {
        AlertDialog.Builder(this)
            .setTitle("실패")
            .setMessage("비밀번호가 잘못되었습니다.")
            .setPositiveButton("확인") { _, _ -> }
            .create()
            .show()
        }
      ~~~
      
  
  
  
  
  
  
  
  
  
  
  * 초기화
    - onCreate 함수는 앱의 화면이 다 그려진 이후에 호출된다.
    - 따라서 앱에 기본적으로 보여줘야 하는 경우 선언과 함께 초기화 해주어야 한다.
      ~~~
            private val firstNumberPicker: NumberPicker by lazy {
            findViewById<NumberPicker>(R.id.firstNumberPicker)
                .apply {
                    minValue = 0
                    maxValue = 9
                }
            }
            
            override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            initNumberPicker()
            initOpenButton()
            initChangePasswordButton()
            }

            private fun initNumberPicker() {
                firstNumberPicker
                secondNumberPicker
                thirdNumberPicker
            }
      ~~~
      
  
  
  
  
  
  
  
  
  
  
  
  
  * Thread
    - DB와 상호작용할때 쓰레드를 이용하는 것은 필수
    
    - UI와 상호작용
      + UI와 상호작용하기 위해선 메인 쓰레드를 사용해야 하는데, 이를 연결해주는 것을 핸들러가 수행해준다
      ~~~
        private val handler = Handler(Looper.getMainLooper())
      ~~~
    - removeCallback
      + removeCallback을 통해 이전에 수행되지 않은 러너블이 존재한다면 지워준다
      ~~~
            diaryEditText.addTextChangedListener {
                Log.d("DiaryActivity", "text Changed :: $it")
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 500)
            }
      ~~~
    - postDelay   
      + postDelay는 변화가 일어난 시점에 바로 수행하는 것이 아닌, 주어진 시간동안 관찰하여 추가적인 이벤트가 나타나지 않을 경우 수행함을 의미
      ~~~
            diaryEditText.addTextChangedListener {
                Log.d("DiaryActivity", "text Changed :: $it")
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 500)
            }
      ~~~         
    - 타이머로써 활용
      ~~~
            timer = timer(period = 5 * 1000) {
            runOnUiThread {
                Log.d("PhotoFrame", "5초가 지나감 !!")

                val current = currentPosition
                val next = if (photoList.size <= currentPosition + 1) 0 else currentPosition + 1

                backgroundPhotoImageView.setImageURI(photoList[current])

                photoImageView.alpha = 0f
                photoImageView.setImageURI(photoList[next])
                photoImageView.animate()
                    .alpha(1.0f)
                    .setDuration(1000)
                    .start()

                currentPosition = next
            }

        }
      ~~~ 
  
  
  
  
  
  
  
  
  
  
  
  
  * 권한 
    - 권한 부여 확인하기
      ~~~
            when {
                ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED -> {
                    navigatePhotos()
                }
                shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE) -> {
                    showPermissionContextPopup()
                }
                else -> {
                    requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1000)
                }
            }
      ~~~
      + android.Manifest.permission.READ_EXTERNAL_STORAGE이 부여 되어 있으면 PackageManager.PERMISSION_GRANTED가 아니면 DENIED를 반환함
      + cntl 눌러서 들어가보면 함수 설명 및 리턴이 무엇인지 잘 적혀있음
      + shouldShowRequestPermissionRationale은 인자로온 권한이 교육용 확인을 위한 팝업을 띄워야(필요한 것인지) 하는 건지를 알려줌
      + requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1000)은 권한(들)을 요청하는 것, 1000은 리퀘스트 코드임(추후 result 에서 구분하기 위한 키값)
      + 교육용 확인을 위한 팝업을 띄울 때 나만의 방식으로 넣는 것
        ~~~
          private fun showPermissionContextPopup() {
              AlertDialog.Builder(this)
                  .setTitle("권한이 필요합니다.")
                  .setMessage("전자액자에 앱에서 사진을 불러오기 위해 권한이 필요합니다.")
                  .setPositiveButton("동의하기") { _, _ ->
                      requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1000)
                  }
                  .setNegativeButton("취소하기") { _, _ -> }
                  .create()
                  .show()

          }
        ~~~
    - 권한 승인 확인
      + 권한이 승인 된건지 아닌지는 onRequestPermmsionsResult에서 처리 
        ~~~
            override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)

                when (requestCode) {
                    1000 -> {
                        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                            navigatePhotos()

                        } else {
                            Toast.makeText(this, "권한을 거부하셨습니다.", Toast.LENGTH_SHORT).show()
                        }
                    }
                    else -> {
                        //
                    }
                }
              }
        ~~~
  
  
  
  
  
  
  
  * 이미지 다루기
    - 프로바이더 생성 (이미지 가져오기) : SAF(stroage access framework)
      ~~~
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
      ~~~
      
    - 이미지를 uri로 다루기
      ~~~
            private val imageUriList: MutableList<Uri> = mutableListOf()
            val intent = Intent(this, PhotoFrameActivity::class.java)
            imageUriList.forEachIndexed { index, uri ->
                intent.putExtra("photo$index", uri.toString())
            }

            private fun getPhotoUriFromIntent() {
                val size = intent.getIntExtra("photoListSize", 0)
                for (i in 0..size) {
                    intent.getStringExtra("photo$i")?.let {
                        photoList.add(Uri.parse(it))
                    }
                }
            }
      ~~~
  
</details>


# 코틀린

5. null 체크가 상당히 중요함
7. 공식언어 살펴볼것


12. 앱의 위젯들의 기본적인 색깔들을 values의 theme가 결정한다. 
13. theme의 영향을 받지 않도록 하려면 theme에서 설정해주거나 Appcompat_Button과 같이 영향을 받지 않는 위젯을 사용한다
14. theme에서 NoActionbar를 설정해주고, 매니페스트에서 해당 테마값을 선택하면 액션바는 없어진다
15. getSharedPreferences에서 해당 파일을 다른 앱과 공유하고 싶지 않을 땐 private 설정
16. getSharedPreferences도 맵처럼 키, 밸류로 구성
17. AlertDialog에서 setPositiveButton에서 람다식을 넘길때 지금까지와 다르게 인자가 2개라서 생략이 불가능. 원래는 dialog와 which를 넘겨야 하지만 사용하지 않기에 _로 변환
18. oncreate는 뷰가 완전히 그려진 이후에 불러지기 때문에 numberpicker를 초기화할 때 min, max를 미리 적용
19. UI를 수정하기 위해 메인핸들러와 연결해주는 것을 핸들러가 수행
20. removeCallback을 통해 이전에 수행되지 않은 러너블이 존재한다면 지워준다
21. postDelay는 변화가 일어난 시점에 바로 수행하는 것이 아닌, 주어진 시간동안 관찰하여 추가적인 이벤트가 나타나지 않을 경우 수행함을 의미


# 코테
1. 자바 배열 한번에 출력
2. 배열로 스택 변환방법
3. 




# 계산기
1. DB에 저장할때 쓰레드는 필수
2. 다른 쓰레드에서 메인 쓰레드로 넘어오는 과정을 ???가 담당
3. constraint에서 양쪽을 최대로 하려면 0dp를 주고 제약조건을 건다
4. constraint에서 가중치를 주는 방법에는 제약조건 constraint 중 weight에 관련된 속성을 이용하는 법이 있다
5. 안드로이드 머터리얼 테마에 있는 ripple > 선택시 물결처럼 촥 퍼지는 효과
5_2. ripple에서 color는 눌렀을 때 색, background는 item 태그를 통해 다시 설정해줘야 함
6. 안드로이드 네임스페이스가 추가안되어있는경우 android:color 에 오류


7. rentangle을 라운드 효과를 넣으려면 corner 속성을 추가
8. shape 안에 solid 속성을 넣어야 색이 칠해짐
9. stroke 속성이 태두리를 설정함
- stateListAnimator에 "@null"을 넣어 기본적으로 적용중인 애니메이션을 취소할 수 있음

10. 기본 머터리얼 테마 적용을 받지 않기 위해선 appcompat button 사용
11. asset vecter 이미지 활용

- 입력받은 String을 split하고 last를 사용하면 나눠진 토큰 기준 마지막 것을 가져올 수 있음
- String에서 dropLast를 사용하면 끝 한단어가 삭제됨
- val ssb = SpannableStringBuilder(expressionTextView.text)
        ssb.setSpan(
            ForegroundColorSpan(getColor(R.color.green)),
            expressionTextView.text.length - 1,
            expressionTextView.text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
텍스트의 '일부' 에만 색을 입히거나, 크기를 늘리거나 등등 효과를 넣을 수 있게 해주는 녀석입니다.
입력받았을때 기준 뒤에 한자리가 연산자이기에 이렇게 설정
마지막 요소는 앞뒤로 색을 더 적용할 것인가 의미

- fun String.isNumber(): Boolean {
    return try {
        this.toBigInteger()
        true
    } catch (e: NumberFormatException) {
        false
    }

}

이것처럼 try catch를 이용한 결과도 가능
이때 BigInteger는 범위가 방대한 인티저임

- DB 사용하기
#1 앱 그래들 추가
1. 
plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-kapt'
}

2.
   kapt "androidx.room:room-compiler:2.2.6"

3.     
implementation "androidx.room:room-runtime:2.2.6"

#2 kt 파일 작성
package fastcampus.aop.part2.chapter4.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class History(
    @PrimaryKey val uid: Int?,
    @ColumnInfo(name = "expression") val expression: String?,
    @ColumnInfo(name = "result") val result: String?
)

이렇게 하면 히스토리라는 테이블이 생성될 떄 위처럼 구성되어 만들어짐

#3 
히스토리 테이블에 대한 인터페이스를 만든다
> DB 조작에 대한 정의를 내림(조회, 저장, 삭제 등을 어떻게 할건지)
package fastcampus.aop.part2.chapter4.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import fastcampus.aop.part2.chapter4.model.History

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history")
    fun getAll(): List<History>

    @Insert
    fun insertHistory(history: History)

    @Query("DELETE FROM history")
    fun deleteAll()

//    @Delete
//    fun delete(history: History)
//
//    @Query("SELECT * FROM history Where result LIKE :result LIMIT 1")
//    fun findByResult(result: String):History
}

> 쿼리문 작성 요령 이나 아래 함수 작성 요령 좀더 공부

#4 
실제 DB 만들기 위해 추상 클래스 작성
package fastcampus.aop.part2.chapter4

import androidx.room.Database
import androidx.room.RoomDatabase
import fastcampus.aop.part2.chapter4.dao.HistoryDao
import fastcampus.aop.part2.chapter4.model.History

@Database(entities = [History::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}

> @Database()
어노테이션으로 데이터베이스 라고 알려주는 거

> entities = [History::class], version = 1
DB에 히스토리를 사용하겠다 등록해주는 것

> abstract fun historyDao(): HistoryDao
사용할 수 있도록 작성

#5
메인에서 실제 사용
lateinit var db: AppDatabase

> oncreate에서 
db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "historyDB"
        ).build()

> result 눌렸을 때
Thread(Runnable {
            db.historyDao().insertHistory(History(null, expressionText, resultText))
        }).start()

> history 눌렸을 때
        Thread(Runnable {
            db.historyDao().getAll().reversed().forEach {
                runOnUiThread {
                    val historyView = LayoutInflater.from(this).inflate(R.layout.history_row, null, false)
                    historyView.findViewById<TextView>(R.id.expressionTextView).text = it.expression
                    historyView.findViewById<TextView>(R.id.resultTextView).text = "= ${it.result}"

                    historyLinearLayout.addView(historyView)
                }
            }

        }).start()
> 이때 히스토리를 보여주는 방식(디자인)을 지정해주지 않았기에 인플레이터를 통해서 지정해줌

- LinearLayout에 removeAllViews()를 사용하면 다 없어짐




# 전자액자

- 권한 부여 확인
            when {
                ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED -> {
                    navigatePhotos()
                }
                shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE) -> {
                    showPermissionContextPopup()
                }
                else -> {
                    requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1000)
                }

            }

> android.Manifest.permission.READ_EXTERNAL_STORAGE이 부여 되어 있으면 PackageManager.PERMISSION_GRANTED가 아니면 DENIED를 반환함
>> cntl 눌러서 들어가보면 함수 설명 및 리턴이 무엇인지 잘 적혀있음

> shouldShowRequestPermissionRationale은 인자로온 권한이 교육용 확인을 위한 팝업을 띄워야(필요한 것인지) 하는 건지를 알려줌

>  requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1000)
은 권한(들)을 요청하는 것, 1000은 리퀘스트 코드임(추후 result 에서 구분하기 위한 키값)

- 교육용 확인을 위한 팝업을 띄울 때 나만의 방식으로 넣는 것
    private fun showPermissionContextPopup() {
        AlertDialog.Builder(this)
            .setTitle("권한이 필요합니다.")
            .setMessage("전자액자에 앱에서 사진을 불러오기 위해 권한이 필요합니다.")
            .setPositiveButton("동의하기") { _, _ ->
                requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1000)
            }
            .setNegativeButton("취소하기") { _, _ -> }
            .create()
            .show()

    }

- Linear에서 높이를 0으로 하고 가로와 세로간의 비율로 주는 설정하는 방법
    <LinearLayout
        android:id="@+id/firstRowLinearLayout"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintDimensionRatio="H,3:1">


- ImageView 안에 들어가는 이미지를 어떻게 조절한것인지 나타내는 속성 scaleType
        <ImageView
            android:id="@+id/imageView11"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:scaleType="centerCrop" />


- 권한이 승인 된건지 아닌지는 onRequestPermmsionsResult에서 처리 
> cntl눌러서 본문에 보면 다 나와있음
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            1000 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    navigatePhotos()

                } else {
                    Toast.makeText(this, "권한을 거부하셨습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            else -> {
                //
            }
        }
    }


- 프로바이더 생성 (이미지 가져오기) > SAF(stroage access framework)

       val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"

- 이미지를 uri로 다루기
    private val imageUriList: MutableList<Uri> = mutableListOf()
            val intent = Intent(this, PhotoFrameActivity::class.java)
            imageUriList.forEachIndexed { index, uri ->
                intent.putExtra("photo$index", uri.toString())
            }

    private fun getPhotoUriFromIntent() {
        val size = intent.getIntExtra("photoListSize", 0)
        for (i in 0..size) {
            intent.getStringExtra("photo$i")?.let {
                photoList.add(Uri.parse(it))
            }
        }
    }

- xml에서 겹친 뷰들은 뒤쪽에 온게 더 앞쪽에 옴


- 타이머와 액션(쓰레드 활용)
        timer = timer(period = 5 * 1000) {
            runOnUiThread {

                Log.d("PhotoFrame", "5초가 지나감 !!")

                val current = currentPosition
                val next = if (photoList.size <= currentPosition + 1) 0 else currentPosition + 1

                backgroundPhotoImageView.setImageURI(photoList[current])

                photoImageView.alpha = 0f
                photoImageView.setImageURI(photoList[next])
                photoImageView.animate()
                    .alpha(1.0f)
                    .setDuration(1000)
                    .start()

                currentPosition = next
            }

        }

- 이미지 뷰 URI로 설정가능
                photoImageView.setImageURI(photoList[next])


- 이미지 뷰 애니매이션 주기(알파를 1.0으로 줘서 투명해지게)
                photoImageView.animate()
                    .alpha(1.0f)
                    .setDuration(1000)
                    .start()

- 타이머와 수명주기
타이머가 백그라운드에서도 동작하기 떄문에 이를 껏따가 켰다가 하기 위해서 수명주기에 맞춰 제어가 필요

    override fun onStop() {
        super.onStop()

        Log.d("PhotoFrame", "onStop!!! timer cancel")
        timer?.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("PhotoFrame", "onDestroy!!! timer cancel")
        timer?.cancel()
    }

    override fun onStart() {
        super.onStart()

        Log.d("PhotoFrame", "onStart!!! timer start")
        startTimer()
    }


- 화면 가로로 하기
매니페스트에서 가로로 설정할 수 있음
        <activity android:name=".PhotoFrameActivity"
            android:screenOrientation="landscape"
            />



@ 뽀모도로 타이머
- Constraint
체인 상태 >         app:layout_constraintHorizontal_chainStyle="packed"
이렇게하면 붙어있는 뷰와 거리를 좁힌다(붙어 있도록)
>> 체인상태에서만 가능
>>> 체인이란? 안드로이드 공식 문서 참고

- 표현식 사용
private fun createCountDownTimer(initialMillis: Long) =
        object : CountDownTimer(initialMillis, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                updateRemainTime(millisUntilFinished)
                updateSeekBar(millisUntilFinished)
            }

            override fun onFinish() {
                completeCountDown()
            }
        }
> return을 제거하고 바로 =로 선언


- 시크바
<SeekBar
        android:id="@+id/seekBar"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginHorizontal="20dp"
        android:max="60"
        android:progressDrawable="@color/transparent"
        android:thumb="@drawable/ic_thumb"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/remainMinutesTextView"
        app:tickMark="@drawable/drawable_tick_mark" />
> 선언

seekBar.progress = (remainMillis / 1000 / 60).toInt()
> 시크바 틱 제어

    seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    if (fromUser) {
                        updateRemainTime(progress * 60 * 1000L)
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    stopCountDown()
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    seekBar ?: return

                    if (seekBar.progress == 0) {
                        stopCountDown()
                    } else {
                        startCountDown()
                    }
                }
            }
        )

> 시크바에 대한 리스너





- 시크바 썸(틱 그림)
        android:progressDrawable="@color/transparent"
        android:thumb="@drawable/ic_thumb"
        app:tickMark="@drawable/drawable_tick_mark"

<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">

    <solid android:color="@color/white"/>
    <size android:width="2dp" android:height="5dp"/>

</shape>

> 틱을 이미지로 설정
> 기본 색을 틱 배경으로 해둘 경우 그림이 이상함 그래서 progressDrawalbe로 별도의 색 지정
> 눈금을 표시하기 위해 app:tickMark을 사용



- 벡터 이미지
장점은 모든 해상도에 대하여 일관적인 상태로 보여질 수 잇음
그릴때 리소스를 많이 잡아먹기에 간단한거로 사용하는 것이 좋음
최대 200 * 200 권장








- 다국어 관련 워링 없애는 것
# main
    @SuppressLint("SetTextI18n")
# xml
        tools:ignore="ContentDescription" 
        tools:ignore="HardcodedText" 


- 카운트 다운을 위한 라이브러리가 있음
    private fun createCountDownTimer(initialMillis: Long) =
        object : CountDownTimer(initialMillis, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                updateRemainTime(millisUntilFinished)
                updateSeekBar(millisUntilFinished)
            }

            override fun onFinish() {
                completeCountDown()
            }
        }


                    fromUser: Boolean

>>??

- 널일때 바로 리턴해버리는 코드 (간결)
                    seekBar ?: return



- 사운드 pool
    private val soundPool = SoundPool.Builder().build()

    private fun initSounds() {
        tickingSoundId = soundPool.load(this, R.raw.timer_ticking, 1)
        bellSoundId = soundPool.load(this, R.raw.timer_bell, 1)
    }

        tickingSoundId?.let { soundId ->
            soundPool.play(soundId, 1F, 1F, 0, -1, 1F)
        }

> 초기화(빌더 형식으로 구성되어있음)
>> 상세내용은 공식문서 참고
>>> 사운드 파일은 resource/raw파일에 넣어두면 됨
>>>> 루프값이 -1일 경우 계속 반복해서 해당 사운드를 재생한다를 의미





- 흰색화면이 보였다가 지정한 배경이 보일 경우
> 최상단 컨테이너의 색을 지정하는 것이 아닌, 윈도우 백그라운드를 변경해야됨
>> 윈도우 백그라운드경우 theme에서 변경 가능
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Theme.Aoppart2chapter06" parent="Theme.MaterialComponents.DayNight.NoActionBar">
        <!-- Status bar color. -->
        <item name="android:statusBarColor">@color/pomodoro_red</item>
        <!-- Customize your theme here. -->
        <item name="android:windowBackground">@color/pomodoro_red</item>
    </style>
</resources>









- 상태바 색깔변경
        <item name="android:statusBarColor">@color/pomodoro_red</item>









- 텍스트 정렬을 아래쪽으로 하는 법
      app:layout_constraintBaseline_toBaselineOf="@id/remainMinutesTextView"







 

코드 다시 확인





@ 녹음기
* 틀 짜기
- 구현해야 할 상태를 크게 4개로 잡아 enum class로 선언
- 미리 지정해둔 이유는 상태마다 UI가 서로 다르게 보여져야 하기때문에 정해두는 것
- 

* state
private var state = State.BEFORE_RECORDING
        set(value) {
            field = value
            resetButton.isEnabled = (value == State.AFTER_RECORDING) || (value == State.ON_PLAYING)
            recordButton.updateIconWithState(value)
        }
> 이렇게 하면 state가 바뀔떄마다 updateIconWithState가 불림
>>???? 왜



* 녹음 버튼을 하나의 객체로 만들어서 관리하는 것

enum class State {
    BEFORE_RECORDING,
    ON_RECORDING,
    AFTER_RECORDING,
    ON_PLAYING
}


import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageButton

class RecordButton(
    context: Context,
    attrs: AttributeSet
) : AppCompatImageButton(context, attrs) {

    init {
        setBackgroundResource(R.drawable.shape_oval_button)
    }

    fun updateIconWithState(state: State) {
        when (state) {
            State.BEFORE_RECORDING -> {
                setImageResource(R.drawable.ic_record)
            }
            State.ON_RECORDING -> {
                setImageResource(R.drawable.ic_stop)
            }
            State.AFTER_RECORDING -> {
                setImageResource(R.drawable.ic_play)
            }
            State.ON_PLAYING -> {
                setImageResource(R.drawable.ic_stop)
            }
        }
    }
}


    <fastcampus.aop.part2.chapter07.RecordButton
        android:id="@+id/recordButton"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_marginBottom="50dp"
        android:padding="25dp"
        android:scaleType="fitCenter"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        tools:src="@drawable/ic_record" />

> 클래스가 xml로 사용될 수 있음
> state라는 클래스를 만들어두면서 일괄적으로 관리가 가능해짐(ex when)
> 



* 서브 클래스 
- context, attributeset 등을 전달받아야 함(공식문서 참고)
- 



* appcompat
- 안드로이드 업데이트에 대한 이전 버전에 대한 대응이 필요함
- 이전 버전에 대한 호환성이 보장되는 라이브러리가 appcompat
- 프로젝트 기본 설정으로 기본적으로 일부 일반적인 뷰들도 appcompat으로 대응하여 변환해주는 기능이 설정되어 있음
- 






* 마이크 녹음
- 권한 설정 기본 상식
> 위험 권한이라 런타임중에 사용자에게 허가를 요청하는 과정을 거쳐야 함
> 매니페스트에 추가해야됨
>

- 권한 실제 요청하기
    private val requiredPermissions = arrayOf(Manifest.permission.RECORD_AUDIO)

    companion object {
        private const val REQUEST_RECORD_AUDIO_PERMISSION = 201
    }

 requestPermissions(requiredPermissions, REQUEST_RECORD_AUDIO_PERMISSION)

> 한번에 여러개의 요청 가능 


- grantResults.firstOrNull()
> 여러개의 권한 요청 결과들 중 ????







* 레코더 소스와 코덱(인코더, 디코더)와 컨테이너(포맷) 
- 포맷과 코덱의 상호 호환하는 것이 다름. 공식문서를 참고하여 서로 호환되는 것을 조합하여 사용해야 한다
- 오디오 파일들은 메모리 해제를 권장한다.(크기가 크기 때문에)



- 사용하기
private var recorder: MediaRecorder? = null
// 선언

recorder = MediaRecorder()
            .apply {
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                setOutputFile(recordingFilePath)
                prepare()
            }
// 초기화

recorder?.start()
// 시작

recorder?.run {
            stop()
            release()
        }
recorder = null
// 녹음 종료







* 미디어 플레이어
- 상태 주기가 있음(공식문서 참고)
- 미디어 플레이어를 사용하는 경우 Asynk를 많이 사용함(이번 프로젝트의 경우에는 로컬의 파일을 사용하기 때문에 prepare로 충분)

- 사용하기 

private var player: MediaPlayer? = null
// 선언

player = MediaPlayer()
            .apply {
                setDataSource(recordingFilePath)
                prepare()
            }
// 초기화


player?.start()
// 재생

player?.release()
player = null
// 정지




* drawing(커스텀)
- 기본 개념
> 공식문서 참고
> 캔버스와 페인트라는 개념 존재
> ondraw를 오버라이드하는 것, 그려야 할 것 크기를 인지하는 것이 핵심
> paint는 무거운 리소스라 ondraw 이전에 생성해두고 사용


- SoundVisualize
+ 먼저 paint 객체 생성
private val amplitudePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = context.getColor(R.color.purple_500)
        strokeWidth = LINE_WIDTH
        strokeCap = Paint.Cap.ROUND
    }
> Alias는 계단화방지 (좀더 부드러운 테두리)

> 4가지(length, width, color, space) 결정
 companion object {
        private const val LINE_WIDTH = 10F
        private const val LINE_SPACE = 15F
        private const val MAX_AMPLITUDE = Short.MAX_VALUE.toFloat()
        private const val ACTION_INTERVAL = 20L
    }

+ 실제 그리기를 설정
  drawingAmplitudes
            .let { amplitudes ->
                if (isReplaying) {
                    amplitudes.takeLast(replayingPosition)
                } else {
                    amplitudes
                }
            }
            .forEach { amplitude ->
                val lineLength = amplitude / MAX_AMPLITUDE * drawingHeight * 0.8F
	   // 화면 전체에서 80프로만 채움
	
                offsetX -= LINE_SPACE
                if (offsetX < 0) return@forEach

                canvas.drawLine(
                    offsetX,
                    centerY - lineLength / 2F,
                    offsetX,
                    centerY + lineLength / 2F,
                    amplitudePaint
                )
            }


+ 실시간으로 들어오는 데이터를 다시 그려주기 위한 에니메이션(쓰레드 활용)
    private val visualizeRepeatAction: Runnable = object : Runnable {
        override fun run() {
            if (!isReplaying) {
                val currentAmplitude = onRequestCurrentAmplitude?.invoke() ?: 0
                drawingAmplitudes = listOf(currentAmplitude) + drawingAmplitudes
            } else {
                replayingPosition++
            }
            invalidate()

            handler?.postDelayed(this, ACTION_INTERVAL)
        }
    }

> 그려질 것이 있는지 확인하고 추가하는 과정
메인에서 결과를 받아오고, 그 값에 따라 추가하는 과정
soundVisualizerView.onRequestCurrentAmplitude = {
            recorder?.maxAmplitude ?: 0
        }

val currentAmplitude = onRequestCurrentAmplitude?.invoke() ?: 0














@
* 현제 테마 속성으로 지정되어 있는 기본 액션바 높이 크기 접근
 android:layout_height="?attr/actionBarSize"

*버튼 위젯 이름 지정할 때 동사+버튼(Button)

* 상수선언은 companion을 이용

* InputType 중 textUrl이라는 속성값도 있음

* webview
	- 기본적으로 https 접근을 막는다. 이를 다른 곳에선 https로 접근할 경우 http로 돌ㄹ려서 접근시켜버리는 것을 사용한다.
	  if (actionId == EditorInfo.IME_ACTION_DONE) {
        val loadingUrl = v.text.toString()
        if (URLUtil.isNetworkUrl(loadingUrl)) {
          webView.loadUrl(loadingUrl)
        } else {
          webView.loadUrl("http://$loadingUrl")
        }
      }
	- https 접근을 허용하는 매니페스트 속성       
  		android:usesCleartextTraffic="true"
	- 디폴트 웹 브라우저가 존재하기에, 로컬 웹뷰를 사용하려면 아래와같이 사용
  		webView.apply {
      			webViewClient = WebViewClient()
      			settings.javaScriptEnabled = true
  		 }
	- goBack, goForward, canGoBack 등의 기능을 제공



	



* 이미지버튼
- 눌렸을 때 ripple 효과를 주기위해 기본적으로 제공하는 백그라운드 사용
            android:background="?attr/selectableItemBackground"
	
- 가로, 세로를 비율로 설정하기
	app:layout_constraintDimensionRatio="1:1"




* 주소 입력받는 edittext
	- 입력받은 후 키보드를 내리도록 하는 속성
	 android:imeOptions="actionDone"

	- 입력받은 후 이벤트 처리하는 부분
	addressBar.setOnEditorActionListener { v, actionId, event ->
     	 if (actionId == EditorInfo.IME_ACTION_DONE) {
      	  val loadingUrl = v.text.toString()
      	  if (URLUtil.isNetworkUrl(loadingUrl)) {
      	    webView.loadUrl(loadingUrl)
       	 } else {
         	 webView.loadUrl("http://$loadingUrl")
       	 }
     	 }
   return@setOnEditorActionListener false
   // false를 통해 내리기 위해 반환
}
// 키보드 내리고 주소 가져오기


	- 셰이플 드로어블로 색상주기
	android:background="@drawable/shape_address_bar"

	<?xml version="1.0" encoding="utf-8"?>
	<shape xmlns:android="http://schemas.android.com/apk/res/android"
    	android:shape="rectangle">

	    <solid android:color="@color/light_gray"/>
    	<corners android:radius="16dp"/>

	</shape>

	- 커서도 라운드값을 받도록 패딩을 넣어야 함


* 툴바
- 툴바와 내용간의 구분을 위해 그림자와, 색을 준다
        android:background="@color/white"
        android:elevation="4dp"



* 내려서 새로고침(SwipeLayout)
- gradle 추가 - 공식문서 참고
- 배치하기
    <androidx.swiperefreshlayout.widget.SwipeRefreshLayout
        android:id="@+id/refreshLayout"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/toolbar">

        <WebView
            android:id="@+id/webView"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />

    </androidx.swiperefreshlayout.widget.SwipeRefreshLayout>

- 새로고침을 사용자가 요청함을 인지하는 리스너 설정
    refreshLayout.setOnRefreshListener {
      webView.reload()
    }

- 프로그레스 조작
+ 웹뷰Client를 받아서 재정의하여서 reload후 프로그레스 보여줌을 false로 바꾸도록 함
+ 내부 속성을 접근하기 위해서 inner로 설정    
inner class WebViewClient : android.webkit.WebViewClient() {
override fun onPageFinished(view: WebView?, url: String?) {
      super.onPageFinished(view, url)

      refreshLayout.isRefreshing = false
 }
}

+ 사용자가 인지하도록 최소한의 시간을 보장하기
> 컨텐트 프로그레스바 xml 설정
   <androidx.core.widget.ContentLoadingProgressBar
        android:id="@+id/progressBar"
        style="@style/Widget.AppCompat.ProgressBar.Horizontal"
        android:layout_width="0dp"
        android:layout_height="2dp"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/toolbar" />
> 메인에서 선언
  private val progressBar: ContentLoadingProgressBar by lazy {
    findViewById(R.id.progressBar)
  }
> 웹 크롬 클라이언트 사용(자바 스크립트에서 제공하는 일부 이벤트 처리위해 필수)
  inner class WebChromeClient : android.webkit.WebChromeClient() {

    override fun onProgressChanged(view: WebView?, newProgress: Int) {
      super.onProgressChanged(view, newProgress)

      progressBar.progress = newProgress
    }
  }

> 웹 뷰 클라이언트에서 적절한 타이밍에 보이도록 수정
    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
      super.onPageStarted(view, url, favicon)

      progressBar.show()
    }

    override fun onPageFinished(view: WebView?, url: String?) {
      super.onPageFinished(view, url)

      refreshLayout.isRefreshing = false
      progressBar.hide()
      goBackButton.isEnabled = webView.canGoBack()
      goForwardButton.isEnabled = webView.canGoForward()
      addressBar.setText(url)
    }

> 


[황규빈] [오전 11:54] app:layout_constraintDimensionRatio="H, 3:1"
[황규빈] [오전 11:55] android:scaleType="centerCrop"
[황규빈] [오후 12:42] ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
[황규빈] [오후 4:41]         val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
[황규빈] [오후 4:43] requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1000)
[황규빈] [오후 5:04]           intent.getStringExtra("photo$i")?.let{
                photoList.add(Uri.parse(it))
인텐트를 통해 받아온 uri를 파싱하면 이미지에 전달 가능
[황규빈] [오후 9:45] app:layout_constraintVertical_weight="1" 
[황규빈] [오후 9:52] constraint layout에는 레이아웃에 위젯이 속한다는 개념이 없음
[황규빈] [오후 10:10] android:stateListAnimator="@null"
2021년 4월 6일 화요일
[황규빈] [오전 10:36] val ssb = SpannableStringBuilder
[황규빈] [오전 10:50] fun String.isNumber(): Boolean {
    return try {
        this.toBigInteger()
        true
    } catch (e: NumberFormatException) {
        false
    }

}
[황규빈] [오전 11:52] android:tint="?attr/"
        when(number) {
            in 1..10 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_yello)
            in 11..20 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_blue)
            in 21..30 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_red)
            in 31..40 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_gray)
            else -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_green)

        }
[황규빈] [오후 6:50]    <style name="AppTheme.Picker">
        <item name="android:textColorPrimary">@color/black</item>
        <item name="android:textSize">10sp</item>
        <item name="colorControlNormal">#aaaaaa</item>
    </style>
[황규빈] [오후 8:40]             val sharedPreferences = getSharedPreferences("password", Context.MODE_PRIVATE)
[황규빈] [오후 8:48] return@setOnClickListener
[황규빈] [오후 9:21]     private val handler = Handler(Looper.getMainLooper())
