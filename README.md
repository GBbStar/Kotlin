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

  - 문자열 템플릿
    + 더하기 연산으로 2개의 문자를 하나로 합칠 수 있다. 
    + 문자열 내부에서 $기호를 넣으면 해당 영역이 문자가 아닌 코드라는 것을 알려줌(뒤에 공백)
    + 문자열 내부에서 {}와 $를 사용하여 추가적인 수식을 입력할 수도   
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
  <summary> 느낀점 </summary>
    
  <details>
    <summary> -- </summary>
  
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
  * xml
    - ripple
      + 안드로이드 머터리얼 테마에서 지원하는 그리기 효과. 눌렀을때 물결처럼 촥 퍼지는 효과를 가지고 있음
      + ripple에서 color 속성은 눌렀을 떄 색이고, background는 item 태그를 통해 다시 설정해줘야 함     
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
    - DB와 상호작용할때 쓰레드를 이용하는 것은 
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
  </details>
</details>





