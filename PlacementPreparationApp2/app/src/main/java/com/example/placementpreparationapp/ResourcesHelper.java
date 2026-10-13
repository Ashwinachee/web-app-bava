package com.example.placementpreparationapp;

import android.content.Context;
import android.content.Intent;

/**
 * Helper class that builds and launches TopicResourcesActivity
 * with appropriate content and external links for each subject topic.
 */
public class ResourcesHelper {

    // =========================================
    // Launch topic with full resources
    // =========================================

    public static void launch(Context context, String subject, String topic) {
        Intent intent = new Intent(context, TopicResourcesActivity.class);
        intent.putExtra("subject", subject);
        intent.putExtra("topic", topic);

        String[] content = getContent(subject, topic);
        String[] webTitles = getWebTitles(subject, topic);
        String[] webLinks  = getWebLinks(subject, topic);
        String[] ytTitles  = getYtTitles(subject, topic);
        String[] ytLinks   = getYtLinks(subject, topic);

        intent.putExtra("content",    content[0]);
        intent.putExtra("webTitles",  webTitles);
        intent.putExtra("webLinks",   webLinks);
        intent.putExtra("ytTitles",   ytTitles);
        intent.putExtra("ytLinks",    ytLinks);

        context.startActivity(intent);
    }

    // =========================================
    // Notes Content
    // =========================================

    private static String[] getContent(String subject, String topic) {
        switch (subject) {
            case "Java": return new String[]{ getJavaContent(topic) };
            case "OS": return new String[]{ getOSContent(topic) };
            case "CN": return new String[]{ getCNContent(topic) };
            case "SQL": return new String[]{ getSQLContent(topic) };
            case "HR": return new String[]{ getHRContent(topic) };
            case "DSA": return new String[]{ getDSAContent(topic) };
            case "DBMS": return new String[]{ getDBMSContent(topic) };
            case "Aptitude": return new String[]{ getAptitudeContent(topic) };
            default: return new String[]{ "Notes coming soon for " + topic };
        }
    }

    // =========================================
    // Java Content
    // =========================================

    private static String getJavaContent(String topic) {
        switch (topic) {
            case "Java Basics":
                return "Java Basics & Fundamentals\n\n" +
                        "Java is a high-level, class-based, object-oriented programming language.\n\n" +
                        "Key Features:\n• Platform Independent (Write Once, Run Anywhere via JVM)\n• Strongly Typed & Secure\n• Automatic Memory Management (Garbage Collection)\n\n" +
                        "JVM vs JRE vs JDK:\n" +
                        "• JDK = JRE + Development Tools (javac)\n" +
                        "• JRE = JVM + Core Libraries\n" +
                        "• JVM = Executes bytecode (.class files)";

            case "Object Oriented Programming":
            case "OOP Concepts":
                return "Object Oriented Programming (OOP)\n\n" +
                        "4 Main Pillars of OOP:\n\n" +
                        "1. Encapsulation:\nWrapping data (variables) and code (methods) together. Achieved using private fields with public getters/setters.\n\n" +
                        "2. Inheritance:\nAcquiring properties of a parent class using 'extends'. Supports code reusability.\n\n" +
                        "3. Polymorphism:\nOne method, many forms.\n• Compile-time: Method Overloading\n• Runtime: Method Overriding\n\n" +
                        "4. Abstraction:\nHiding internal details and showing only essential functionality. Achieved using Abstract Classes and Interfaces.";

            case "Collections Framework":
                return "Java Collections Framework\n\n" +
                        "The Collection framework provides data structures for efficient data manipulation.\n\n" +
                        "Core Interfaces:\n" +
                        "• List (Ordered, duplicates allowed): ArrayList, LinkedList, Vector\n" +
                        "• Set (Unique elements): HashSet, LinkedHashSet, TreeSet\n" +
                        "• Map (Key-Value pairs): HashMap, LinkedHashMap, TreeMap, ConcurrentHashMap\n" +
                        "• Queue / Deque: PriorityQueue, ArrayDeque";

            case "Multithreading":
                return "Multithreading & Concurrency\n\n" +
                        "Multithreading allows concurrent execution of two or more threads.\n\n" +
                        "Creation Methods:\n1. Extending Thread class\n2. Implementing Runnable interface\n3. Callable & ExecutorService\n\n" +
                        "Synchronization:\nPrevents thread interference using 'synchronized' keyword, Mutex, and ReentrantLock.";

            default:
                return topic + " – Java Notes and Interview Preparation Guide.\n\nCheck official resources below.";
        }
    }

    // =========================================
    // OS Content
    // =========================================

    private static String getOSContent(String topic) {
        switch (topic) {
            case "Process Management":
                return "What is Process Management?\n\n" +
                        "A process is a program in execution. The OS manages processes through scheduling, creation, and termination.\n\n" +
                        "Process States:\n• New → Ready → Running → Waiting → Terminated\n\n" +
                        "Key Concepts:\n" +
                        "• PCB (Process Control Block) – stores process info\n" +
                        "• Context Switching – saving/restoring process state\n" +
                        "• Process Scheduling – CPU allocation\n\n" +
                        "Scheduling Algorithms:\n• FCFS (First Come First Serve)\n• SJF (Shortest Job First)\n• Round Robin\n• Priority Scheduling";

            case "Threads":
                return "What is a Thread?\n\n" +
                        "A thread is the smallest unit of execution within a process. Multiple threads share the same memory space.\n\n" +
                        "Types:\n• User-level threads\n• Kernel-level threads\n\n" +
                        "Benefits:\n• Faster context switching\n• Resource sharing\n• Improved responsiveness\n\n" +
                        "Problems:\n• Race conditions\n• Deadlocks\n• Synchronization issues";

            case "Memory Management":
                return "Memory Management in OS\n\n" +
                        "The OS manages RAM allocation between processes.\n\n" +
                        "Techniques:\n" +
                        "• Contiguous Allocation – fixed and variable partitions\n" +
                        "• Paging – fixed-size blocks (pages)\n" +
                        "• Segmentation – logical divisions of memory\n" +
                        "• Virtual Memory – extends RAM using disk space\n\n" +
                        "Important Concepts:\n• TLB (Translation Lookaside Buffer)\n• Page Fault\n• Thrashing\n• Belady's Anomaly";

            case "Deadlock":
                return "What is Deadlock?\n\n" +
                        "A deadlock occurs when a set of processes are blocked, each waiting for a resource held by another.\n\n" +
                        "4 Necessary Conditions (Coffman):\n" +
                        "1. Mutual Exclusion\n2. Hold and Wait\n3. No Preemption\n4. Circular Wait\n\n" +
                        "Handling Deadlocks:\n• Prevention – eliminate one of the 4 conditions\n• Avoidance – Banker's Algorithm\n• Detection & Recovery\n• Ignorance (Ostrich Algorithm)";

            case "CPU Scheduling":
                return "CPU Scheduling\n\n" +
                        "CPU scheduling decides which process gets the CPU and for how long.\n\n" +
                        "Algorithms:\n" +
                        "• FCFS – simple, non-preemptive\n" +
                        "• SJF – minimum average waiting time\n" +
                        "• SRTF – preemptive SJF\n" +
                        "• Round Robin – time quantum based\n" +
                        "• Priority Scheduling – highest priority first\n" +
                        "• Multilevel Queue\n\n" +
                        "Metrics:\n• CPU Utilization\n• Throughput\n• Turnaround Time\n• Waiting Time\n• Response Time";

            case "File Systems":
                return "File Systems\n\n" +
                        "A file system organizes and manages data storage on disk.\n\n" +
                        "File Allocation Methods:\n" +
                        "• Contiguous Allocation – fast access, external fragmentation\n" +
                        "• Linked Allocation – flexible, no external fragmentation\n" +
                        "• Indexed Allocation – uses an index block\n\n" +
                        "Directory Structures:\n• Single-level\n• Two-level\n• Tree-structured\n• Acyclic Graph\n\n" +
                        "Popular File Systems:\n• FAT32, NTFS (Windows)\n• ext4 (Linux)\n• APFS (macOS)";

            case "Paging & Segmentation":
                return "Paging\n\n" +
                        "Paging divides logical memory into fixed-size pages and physical memory into frames.\n\n" +
                        "• No external fragmentation\n• May have internal fragmentation\n• Uses a Page Table for address translation\n\n" +
                        "Segmentation\n\n" +
                        "Segmentation divides memory into variable-size logical segments (code, data, stack).\n\n" +
                        "• No internal fragmentation\n• May have external fragmentation\n• Uses a Segment Table\n\n" +
                        "Page Replacement Algorithms:\n• FIFO\n• LRU (Least Recently Used)\n• Optimal\n• Clock Algorithm";

            case "Synchronization":
                return "Process Synchronization\n\n" +
                        "Synchronization coordinates access to shared resources between concurrent processes.\n\n" +
                        "Critical Section Problem:\n• Only one process in critical section at a time\n\n" +
                        "Solutions:\n" +
                        "• Peterson's Algorithm\n• Semaphores (Binary & Counting)\n• Mutex\n• Monitors\n\n" +
                        "Classic Problems:\n• Producer-Consumer Problem\n• Readers-Writers Problem\n• Dining Philosophers Problem";

            default:
                return topic + " – Notes coming soon!\n\nCheck the official resources below.";
        }
    }

    // =========================================
    // CN Content
    // =========================================

    private static String getCNContent(String topic) {
        switch (topic) {
            case "Network Basics":
                return "Computer Networks Basics\n\n" +
                        "A computer network is a set of interconnected devices that communicate and share resources.\n\n" +
                        "Types of Networks:\n• LAN (Local Area Network)\n• MAN (Metropolitan Area Network)\n• WAN (Wide Area Network)\n• PAN (Personal Area Network)\n\n" +
                        "Network Topologies:\n• Bus\n• Star\n• Ring\n• Mesh\n• Hybrid\n\n" +
                        "Important Devices:\n• Hub, Switch, Router\n• Bridge, Gateway, Repeater\n• Modem, Firewall";

            case "OSI Model":
                return "OSI Model (7 Layers)\n\n" +
                        "The OSI model standardizes network communication into 7 layers:\n\n" +
                        "7. Application – HTTP, FTP, SMTP\n" +
                        "6. Presentation – Encryption, Compression\n" +
                        "5. Session – Session Management\n" +
                        "4. Transport – TCP, UDP, Port Numbers\n" +
                        "3. Network – IP, Routing\n" +
                        "2. Data Link – MAC Address, Ethernet\n" +
                        "1. Physical – Cables, Bits\n\n" +
                        "Mnemonic: 'All People Seem To Need Data Processing'";

            case "TCP/IP Model":
                return "TCP/IP Model (4 Layers)\n\n" +
                        "The TCP/IP model is the practical internet model:\n\n" +
                        "4. Application – HTTP, DNS, SMTP, FTP\n" +
                        "3. Transport – TCP (reliable), UDP (fast)\n" +
                        "2. Internet – IP, ICMP, ARP\n" +
                        "1. Network Access – Ethernet, Wi-Fi\n\n" +
                        "TCP vs UDP:\n" +
                        "• TCP: connection-oriented, reliable, ordered\n" +
                        "• UDP: connectionless, fast, no guarantee\n\n" +
                        "TCP 3-Way Handshake: SYN → SYN-ACK → ACK";

            case "IP Addressing":
                return "IP Addressing\n\n" +
                        "An IP address uniquely identifies a device on a network.\n\n" +
                        "IPv4:\n• 32-bit address (e.g. 192.168.1.1)\n• Classes: A, B, C, D, E\n• Private IP ranges\n\n" +
                        "IPv6:\n• 128-bit address\n• Solves IPv4 exhaustion\n\n" +
                        "Subnetting:\n• Divides a network into smaller sub-networks\n• Uses subnet mask (e.g. 255.255.255.0)\n• CIDR notation: 192.168.1.0/24\n\n" +
                        "NAT: Translates private IPs to public IPs";

            case "Network Protocols":
                return "Important Network Protocols\n\n" +
                        "Application Layer:\n• HTTP/HTTPS – Web browsing (port 80/443)\n• FTP – File transfer (port 21)\n• SMTP – Email sending (port 25)\n• DNS – Domain name resolution (port 53)\n• DHCP – IP address assignment\n\n" +
                        "Transport Layer:\n• TCP – Reliable transmission\n• UDP – Fast, connectionless\n\n" +
                        "Network Layer:\n• IP – Routing\n• ICMP – Error reporting (ping)\n• ARP – IP to MAC resolution";

            case "DNS":
                return "Domain Name System (DNS)\n\n" +
                        "DNS translates human-readable domain names to IP addresses.\n\n" +
                        "How DNS Works:\n" +
                        "1. User types www.google.com\n" +
                        "2. Browser checks local cache\n" +
                        "3. Queries DNS Resolver\n" +
                        "4. Root Server → TLD Server → Authoritative Server\n" +
                        "5. Returns IP address\n\n" +
                        "Record Types:\n• A – IPv4 address\n• AAAA – IPv6 address\n• CNAME – Alias\n• MX – Mail server\n• NS – Name server";

            case "HTTP and HTTPS":
                return "HTTP vs HTTPS\n\n" +
                        "HTTP (HyperText Transfer Protocol)\n• Application layer protocol\n• Port 80\n• Stateless – each request is independent\n• Not encrypted\n\n" +
                        "HTTPS (HTTP Secure)\n• Uses SSL/TLS encryption\n• Port 443\n• Provides confidentiality, integrity, authentication\n\n" +
                        "HTTP Methods:\n• GET – retrieve data\n• POST – send data\n• PUT – update data\n• DELETE – remove data\n• PATCH – partial update\n\n" +
                        "HTTP Status Codes:\n• 2xx: Success\n• 3xx: Redirect\n• 4xx: Client error\n• 5xx: Server error";

            default:
                return topic + " – Notes coming soon!\n\nCheck the official resources below.";
        }
    }

    // =========================================
    // SQL Content
    // =========================================

    private static String getSQLContent(String topic) {
        switch (topic) {
            case "SQL Basics":
                return "SQL (Structured Query Language)\n\n" +
                        "SQL is used to manage and manipulate relational databases.\n\n" +
                        "SQL Categories:\n" +
                        "• DDL – CREATE, ALTER, DROP, TRUNCATE\n" +
                        "• DML – SELECT, INSERT, UPDATE, DELETE\n" +
                        "• DCL – GRANT, REVOKE\n" +
                        "• TCL – COMMIT, ROLLBACK, SAVEPOINT\n\n" +
                        "Data Types:\n• INT, VARCHAR, CHAR, TEXT\n• DATE, DATETIME, TIMESTAMP\n• FLOAT, DECIMAL, BOOLEAN";

            case "SELECT Queries":
                return "SELECT Queries\n\n" +
                        "The SELECT statement retrieves data from a table.\n\n" +
                        "Syntax:\nSELECT column1, column2 FROM table_name;\n\n" +
                        "Examples:\n" +
                        "• SELECT * FROM students;\n" +
                        "• SELECT name, age FROM students;\n" +
                        "• SELECT DISTINCT city FROM students;\n\n" +
                        "Filtering:\n• WHERE – filter rows\n• LIKE – pattern matching\n• IN – multiple values\n• BETWEEN – range\n• IS NULL – check null values";

            case "Aggregate Functions":
                return "Aggregate Functions\n\n" +
                        "Aggregate functions perform calculations on groups of rows.\n\n" +
                        "Functions:\n" +
                        "• COUNT() – number of rows\n" +
                        "• SUM() – total sum\n" +
                        "• AVG() – average value\n" +
                        "• MAX() – maximum value\n" +
                        "• MIN() – minimum value\n\n" +
                        "Example:\nSELECT AVG(salary) FROM employees;\n\n" +
                        "GROUP BY – groups rows with same values\n" +
                        "HAVING – filters grouped results (like WHERE for groups)";

            case "SQL Joins":
                return "SQL Joins\n\n" +
                        "Joins combine rows from two or more tables.\n\n" +
                        "Types:\n" +
                        "• INNER JOIN – matching rows in both tables\n" +
                        "• LEFT JOIN – all rows from left + matching from right\n" +
                        "• RIGHT JOIN – all rows from right + matching from left\n" +
                        "• FULL OUTER JOIN – all rows from both tables\n" +
                        "• CROSS JOIN – Cartesian product\n" +
                        "• SELF JOIN – joins table with itself\n\n" +
                        "Syntax:\nSELECT * FROM A INNER JOIN B ON A.id = B.id;";

            case "Subqueries":
                return "Subqueries\n\n" +
                        "A subquery is a query nested inside another query.\n\n" +
                        "Types:\n" +
                        "• Single-row subquery – returns one row\n" +
                        "• Multi-row subquery – returns multiple rows\n" +
                        "• Correlated subquery – depends on outer query\n\n" +
                        "Example:\nSELECT name FROM students\nWHERE marks > (SELECT AVG(marks) FROM students);\n\n" +
                        "Used with: WHERE, HAVING, FROM, SELECT clauses";

            case "SQL Interview Questions":
                return "Top SQL Interview Questions\n\n" +
                        "Q1: Difference between DELETE and TRUNCATE?\n→ DELETE removes specific rows and can be rolled back. TRUNCATE removes all rows and cannot be rolled back.\n\n" +
                        "Q2: What is a view?\n→ A virtual table based on a SQL query result.\n\n" +
                        "Q3: What is an index?\n→ Speeds up data retrieval. Types: Clustered, Non-clustered.\n\n" +
                        "Q4: What is normalization?\n→ Organizing data to reduce redundancy. Forms: 1NF, 2NF, 3NF, BCNF.\n\n" +
                        "Q5: What is a stored procedure?\n→ A precompiled set of SQL statements stored in the database.";

            default:
                return topic + " – Notes coming soon!\n\nCheck the official resources below.";
        }
    }

    // =========================================
    // HR Content
    // =========================================

    private static String getHRContent(String topic) {
        switch (topic) {
            case "Tell Me About Yourself":
                return "Tell Me About Yourself\n\n" +
                        "This is usually the first HR question. Use the PRESENT-PAST-FUTURE formula:\n\n" +
                        "Structure:\n" +
                        "• PRESENT – Who you are now (education, current skills)\n" +
                        "• PAST – What you've done (projects, internships, achievements)\n" +
                        "• FUTURE – What you aim to do (your career goal)\n\n" +
                        "Tips:\n• Keep it under 2 minutes\n• Be confident and structured\n• Highlight relevant skills\n• End with why you're excited about this role\n\n" +
                        "Example Start:\n'I'm a final-year CSE student at [College], specializing in Java and web development. I've worked on [projects]...'";

            case "Strengths and Weaknesses":
                return "Strengths & Weaknesses\n\n" +
                        "Strengths:\n• Choose 3 relevant strengths\n• Give examples for each\n• Align with the job role\n\n" +
                        "Common Strong Strengths:\n• Problem-solving ability\n• Fast learner\n• Team player\n• Attention to detail\n• Strong communication\n\n" +
                        "Weaknesses (Smart Approach):\n• Choose a real weakness\n• Show you're working on it\n• Don't say 'I'm a perfectionist'\n\n" +
                        "Example Weakness:\n'I used to struggle with public speaking, but I've joined debate clubs and now present confidently in team meetings.'";

            case "Why Should We Hire You?":
                return "Why Should We Hire You?\n\n" +
                        "This is your elevator pitch. Connect your skills to the company's needs.\n\n" +
                        "Formula: Skills + Experience + Value to Company\n\n" +
                        "Key Points:\n• Highlight your unique skills\n• Show you've researched the company\n• Mention how you'll contribute\n• Be confident, not arrogant\n\n" +
                        "Example:\n'I bring strong Java and problem-solving skills, along with [project experience]. I'm a fast learner who delivers results. I believe my technical background and passion for [field] align perfectly with your team's needs.'";

            case "Why This Company?":
                return "Why This Company?\n\n" +
                        "Research the company before the interview!\n\n" +
                        "What to Research:\n• Company products and services\n• Company culture and values\n• Recent achievements or news\n• Growth opportunities\n\n" +
                        "Answer Formula:\n• What you admire about the company\n• How their work aligns with your goals\n• What you can contribute\n\n" +
                        "Red Flags to Avoid:\n• Don't say 'good salary'\n• Don't say 'I need a job'\n• Don't give generic answers";

            case "Short-Term and Long-Term Goals":
                return "Career Goals – Short & Long Term\n\n" +
                        "Short-Term Goals (1-2 years):\n• Get placed in a reputed company\n• Learn and master technologies relevant to the role\n• Contribute meaningfully to team projects\n• Build technical depth\n\n" +
                        "Long-Term Goals (5+ years):\n• Grow into a senior engineer or tech lead\n• Work on impactful products\n• Possibly lead a team\n• Contribute to open-source or innovation\n\n" +
                        "Tip: Align your goals with the company's vision.";

            case "Teamwork Questions":
                return "Teamwork Interview Questions\n\n" +
                        "Common Questions:\n• 'Tell me about a time you worked in a team'\n• 'How do you handle disagreements in a team?'\n• 'What role do you play in a team?'\n\n" +
                        "Use the STAR Method:\n• Situation – Set the context\n• Task – Your responsibility\n• Action – What you did\n• Result – Outcome\n\n" +
                        "Key Qualities to Highlight:\n• Communication\n• Adaptability\n• Respect for different opinions\n• Taking ownership\n• Supporting teammates";

            case "Conflict Handling":
                return "Handling Conflict at Work\n\n" +
                        "Interviewers want to see maturity, empathy, and professionalism.\n\n" +
                        "Example Question:\n'Tell me about a conflict you had with a teammate. How did you handle it?'\n\n" +
                        "Approach:\n• Stay calm and professional\n• Listen to understand the other person\n• Focus on the problem, not the person\n• Find a mutually acceptable solution\n• Learn from the experience\n\n" +
                        "Use STAR format to structure your answer.\n\n" +
                        "Avoid:\n• Blaming others\n• Saying you never have conflicts";

            default:
                return topic + " – Preparation tips coming soon!\n\nCheck the resources below.";
        }
    }

    // =========================================
    // DSA Content (re-used from DSATopicNotesActivity)
    // =========================================

    private static String getDSAContent(String topic) {
        return "See study notes for " + topic + " below.";
    }

    // =========================================
    // DBMS Content (brief version)
    // =========================================

    private static String getDBMSContent(String topic) {
        return "See study notes for " + topic + " below.";
    }

    // =========================================
    // Aptitude Content (brief)
    // =========================================

    private static String getAptitudeContent(String topic) {
        return "See study notes for " + topic + " below.";
    }

    // =========================================
    // Web Titles
    // =========================================

    private static String[] getWebTitles(String subject, String topic) {
        switch (subject) {
            case "Java": return new String[]{ "Oracle Java Docs", "GFG – Java Programming", "Javatpoint – Java Tutorial" };
            case "OS": return getOSWebTitles(topic);
            case "CN": return getCNWebTitles(topic);
            case "SQL": return getSQLWebTitles(topic);
            case "HR": return getHRWebTitles(topic);
            case "DSA": return getDSAWebTitles(topic);
            case "DBMS": return getDBMSWebTitles(topic);
            case "Aptitude": return getAptitudeWebTitles(topic);
            default: return new String[]{ "GeeksforGeeks", "Javatpoint" };
        }
    }

    private static String[] getOSWebTitles(String topic) {
        switch (topic) {
            case "Process Management": return new String[]{ "GFG – Process Management", "Javatpoint – Process States", "TutorialsPoint – OS Processes" };
            case "Threads": return new String[]{ "GFG – Threads in OS", "Javatpoint – Threads", "GeeksforGeeks – Multithreading OS" };
            case "Memory Management": return new String[]{ "GFG – Memory Management", "TutorialsPoint – Memory Mgmt", "Javatpoint – Paging" };
            case "Deadlock": return new String[]{ "GFG – Deadlock", "Javatpoint – Deadlock", "TutorialsPoint – Deadlock" };
            case "CPU Scheduling": return new String[]{ "GFG – CPU Scheduling", "Javatpoint – Scheduling Algorithms", "TutorialsPoint – CPU Scheduling" };
            case "File Systems": return new String[]{ "GFG – File Systems", "TutorialsPoint – File Systems", "Javatpoint – File Management" };
            default: return new String[]{ "GFG – Operating Systems", "Javatpoint – OS Tutorial" };
        }
    }

    private static String[] getCNWebTitles(String topic) {
        switch (topic) {
            case "OSI Model": return new String[]{ "GFG – OSI Model", "Cloudflare – OSI Model Explained", "Javatpoint – OSI Layers" };
            case "TCP/IP Model": return new String[]{ "GFG – TCP/IP Model", "Cloudflare – TCP/IP", "Javatpoint – TCP/IP" };
            case "IP Addressing": return new String[]{ "GFG – IP Addressing", "Cisco – IP Addressing", "TutorialsPoint – IP" };
            case "DNS": return new String[]{ "Cloudflare – What is DNS", "GFG – DNS", "Mozilla – DNS Explained" };
            case "HTTP and HTTPS": return new String[]{ "Mozilla – HTTP", "Cloudflare – HTTPS", "GFG – HTTP vs HTTPS" };
            default: return new String[]{ "GFG – Computer Networks", "Javatpoint – CN Tutorial" };
        }
    }

    private static String[] getSQLWebTitles(String topic) {
        switch (topic) {
            case "SQL Basics": return new String[]{ "W3Schools – SQL Basics", "GFG – SQL Tutorial", "SQLZoo – SQL Practice" };
            case "SELECT Queries": return new String[]{ "W3Schools – SQL SELECT", "Mode Analytics – SQL Tutorial", "SQLZoo – SELECT" };
            case "Aggregate Functions": return new String[]{ "W3Schools – SQL Aggregate", "GFG – Aggregate Functions", "Mode Analytics – Aggregations" };
            case "SQL Joins": return new String[]{ "W3Schools – SQL Joins", "GFG – SQL Joins", "Visual Join Tool" };
            case "Subqueries": return new String[]{ "W3Schools – Subqueries", "GFG – Subqueries in SQL", "Mode Analytics – Subqueries" };
            default: return new String[]{ "W3Schools – SQL Tutorial", "GFG – SQL", "SQLZoo" };
        }
    }

    private static String[] getHRWebTitles(String topic) {
        return new String[]{ "InterviewBit – HR Questions", "IndiaBix – HR Interview", "AmbitionBox – Interview Tips" };
    }

    private static String[] getDSAWebTitles(String topic) {
        switch (topic) {
            case "Arrays": return new String[]{ "GFG – Arrays", "LeetCode – Array Problems", "Javatpoint – Arrays" };
            case "Linked List": return new String[]{ "GFG – Linked List", "LeetCode – Linked List", "Visualgo – Linked List" };
            case "Trees": return new String[]{ "GFG – Trees", "LeetCode – Tree Problems", "Visualgo – BST" };
            case "Graphs": return new String[]{ "GFG – Graphs", "LeetCode – Graph Problems", "CP-Algorithms – Graphs" };
            default: return new String[]{ "GFG – " + topic, "LeetCode – " + topic + " Problems" };
        }
    }

    private static String[] getDBMSWebTitles(String topic) {
        return new String[]{ "GFG – " + topic, "Javatpoint – " + topic, "TutorialsPoint – DBMS" };
    }

    private static String[] getAptitudeWebTitles(String topic) {
        return new String[]{ "IndiaBix – " + topic, "GFG – Aptitude – " + topic, "TutorialsPoint – Aptitude" };
    }

    // =========================================
    // Web Links
    // =========================================

    private static String[] getWebLinks(String subject, String topic) {
        switch (subject) {
            case "Java": return new String[]{ "https://docs.oracle.com/en/java/", "https://www.geeksforgeeks.org/java/", "https://www.javatpoint.com/java-tutorial" };
            case "OS": return getOSWebLinks(topic);
            case "CN": return getCNWebLinks(topic);
            case "SQL": return getSQLWebLinks(topic);
            case "HR": return getHRWebLinks(topic);
            case "DSA": return getDSAWebLinks(topic);
            case "DBMS": return getDBMSWebLinks(topic);
            case "Aptitude": return getAptitudeWebLinks(topic);
            default: return new String[]{ "https://www.geeksforgeeks.org", "https://www.javatpoint.com" };
        }
    }

    private static String[] getOSWebLinks(String topic) {
        switch (topic) {
            case "Process Management": return new String[]{ "https://www.geeksforgeeks.org/process-management-in-os/", "https://www.javatpoint.com/os-processes-states", "https://www.tutorialspoint.com/operating_system/os_processes.htm" };
            case "Threads": return new String[]{ "https://www.geeksforgeeks.org/thread-in-operating-system/", "https://www.javatpoint.com/threads-in-operating-system", "https://www.geeksforgeeks.org/multithreading-in-operating-system/" };
            case "Memory Management": return new String[]{ "https://www.geeksforgeeks.org/memory-management-in-operating-system/", "https://www.tutorialspoint.com/operating_system/os_memory_management.htm", "https://www.javatpoint.com/os-paging-with-example" };
            case "Deadlock": return new String[]{ "https://www.geeksforgeeks.org/introduction-of-deadlock-in-operating-system/", "https://www.javatpoint.com/os-deadlocks", "https://www.tutorialspoint.com/operating_system/os_deadlocks.htm" };
            case "CPU Scheduling": return new String[]{ "https://www.geeksforgeeks.org/cpu-scheduling-in-operating-systems/", "https://www.javatpoint.com/os-scheduling-algorithms", "https://www.tutorialspoint.com/operating_system/os_process_scheduling.htm" };
            case "File Systems": return new String[]{ "https://www.geeksforgeeks.org/file-systems-in-operating-system/", "https://www.tutorialspoint.com/operating_system/os_file_system.htm", "https://www.javatpoint.com/os-file-management" };
            default: return new String[]{ "https://www.geeksforgeeks.org/operating-systems/", "https://www.javatpoint.com/os-tutorial" };
        }
    }

    private static String[] getCNWebLinks(String topic) {
        switch (topic) {
            case "OSI Model": return new String[]{ "https://www.geeksforgeeks.org/layers-of-osi-model/", "https://www.cloudflare.com/learning/ddos/glossary/open-systems-interconnection-model-osi/", "https://www.javatpoint.com/osi-model" };
            case "TCP/IP Model": return new String[]{ "https://www.geeksforgeeks.org/tcp-ip-model/", "https://www.cloudflare.com/learning/ddos/glossary/tcp-ip/", "https://www.javatpoint.com/tcp-ip-model" };
            case "IP Addressing": return new String[]{ "https://www.geeksforgeeks.org/introduction-to-ip-addresses/", "https://www.cisco.com/c/en/us/support/docs/ip/routing-information-protocol-rip/13788-3.html", "https://www.tutorialspoint.com/ipv4/index.htm" };
            case "DNS": return new String[]{ "https://www.cloudflare.com/learning/dns/what-is-dns/", "https://www.geeksforgeeks.org/domain-name-server-dns-in-application-layer/", "https://developer.mozilla.org/en-US/docs/Learn/Common_questions/Web_mechanics/What_is_a_domain_name" };
            case "HTTP and HTTPS": return new String[]{ "https://developer.mozilla.org/en-US/docs/Web/HTTP", "https://www.cloudflare.com/learning/ssl/why-is-http-not-secure/", "https://www.geeksforgeeks.org/difference-between-http-and-https/" };
            default: return new String[]{ "https://www.geeksforgeeks.org/computer-network-tutorials/", "https://www.javatpoint.com/computer-network-tutorial" };
        }
    }

    private static String[] getSQLWebLinks(String topic) {
        switch (topic) {
            case "SQL Basics": return new String[]{ "https://www.w3schools.com/sql/", "https://www.geeksforgeeks.org/sql-tutorial/", "https://sqlzoo.net/" };
            case "SELECT Queries": return new String[]{ "https://www.w3schools.com/sql/sql_select.asp", "https://mode.com/sql-tutorial/sql-select-statement/", "https://sqlzoo.net/wiki/SELECT_basics" };
            case "Aggregate Functions": return new String[]{ "https://www.w3schools.com/sql/sql_aggregate_functions.asp", "https://www.geeksforgeeks.org/aggregate-functions-in-sql/", "https://mode.com/sql-tutorial/sql-aggregate-functions/" };
            case "SQL Joins": return new String[]{ "https://www.w3schools.com/sql/sql_join.asp", "https://www.geeksforgeeks.org/sql-join-set-1-inner-left-right-and-full-joins/", "https://joins.spathon.com/" };
            case "Subqueries": return new String[]{ "https://www.w3schools.com/sql/sql_subqueries.asp", "https://www.geeksforgeeks.org/sql-subquery/", "https://mode.com/sql-tutorial/sql-sub-queries/" };
            default: return new String[]{ "https://www.w3schools.com/sql/", "https://www.geeksforgeeks.org/sql/", "https://sqlzoo.net/" };
        }
    }

    private static String[] getHRWebLinks(String topic) {
        return new String[]{ "https://www.interviewbit.com/hr-interview-questions/", "https://www.indiabix.com/hr-interview/questions-and-answers/", "https://www.ambitionbox.com/interviews" };
    }

    private static String[] getDSAWebLinks(String topic) {
        switch (topic) {
            case "Arrays": return new String[]{ "https://www.geeksforgeeks.org/array-data-structure/", "https://leetcode.com/tag/array/", "https://www.javatpoint.com/data-structure-array" };
            case "Linked List": return new String[]{ "https://www.geeksforgeeks.org/data-structures/linked-list/", "https://leetcode.com/tag/linked-list/", "https://visualgo.net/en/list" };
            case "Trees": return new String[]{ "https://www.geeksforgeeks.org/binary-tree-data-structure/", "https://leetcode.com/tag/tree/", "https://visualgo.net/en/bst" };
            case "Graphs": return new String[]{ "https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/", "https://leetcode.com/tag/graph/", "https://cp-algorithms.com/graph/breadth-first-search.html" };
            default: return new String[]{ "https://www.geeksforgeeks.org/data-structures/", "https://leetcode.com/explore/" };
        }
    }

    private static String[] getDBMSWebLinks(String topic) {
        return new String[]{ "https://www.geeksforgeeks.org/dbms/", "https://www.javatpoint.com/dbms-tutorial", "https://www.tutorialspoint.com/dbms/index.htm" };
    }

    private static String[] getAptitudeWebLinks(String topic) {
        return new String[]{ "https://www.indiabix.com/aptitude/questions-and-answers/", "https://www.geeksforgeeks.org/aptitude/", "https://www.tutorialspoint.com/quantitative_aptitude/index.htm" };
    }

    // =========================================
    // YouTube Titles
    // =========================================

    private static String[] getYtTitles(String subject, String topic) {
        switch (subject) {
            case "Java": return new String[]{ "Java Full Course – Telusko", "Java Tutorial – CodeWithHarry", "Java & OOPs – Striver" };
            case "OS": return new String[]{ "OS Full Course – Neso Academy", "Operating Systems – Gate Smashers", "OS Interview Questions – CodeHelp" };
            case "CN": return new String[]{ "CN Full Course – Neso Academy", "Computer Networks – Gate Smashers", "CN for Interviews – Striver" };
            case "SQL": return new String[]{ "SQL Tutorial – Programming with Mosh", "SQL Full Course – freeCodeCamp", "SQL for Interviews – TechTFQ" };
            case "HR": return new String[]{ "HR Interview Tips – Edureka", "Tell Me About Yourself – CS Dojo", "Top HR Questions – Simplilearn" };
            case "DSA": return new String[]{ getDSAYtTitle(topic), "Striver's A2Z DSA Course", "Love Babbar DSA Sheet" };
            case "DBMS": return new String[]{ "DBMS Full Course – Gate Smashers", "DBMS – Neso Academy", "DBMS Interview Prep – Apna College" };
            case "Aptitude": return new String[]{ "Aptitude – CareerRide", "Quantitative Aptitude – Unacademy", "Logical Reasoning – TalentSprint" };
            default: return new String[]{ "YouTube Tutorial" };
        }
    }

    private static String getDSAYtTitle(String topic) {
        switch (topic) {
            case "Arrays": return "Arrays – Striver";
            case "Linked List": return "Linked List – CodeHelp";
            case "Trees": return "Trees – Striver";
            case "Graphs": return "Graphs – CodeHelp";
            case "Dynamic Programming": return "DP – Aditya Verma";
            default: return topic + " – YouTube";
        }
    }

    // =========================================
    // YouTube Links
    // =========================================

    private static String[] getYtLinks(String subject, String topic) {
        switch (subject) {
            case "Java": return new String[]{ "https://www.youtube.com/watch?v=eIrMbAQSU34", "https://www.youtube.com/watch?v=rV_3Lewxx6o", "https://www.youtube.com/playlist?list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz" };
            case "OS": return new String[]{ "https://www.youtube.com/playlist?list=PLBlnK6fEyqRiVhbXDGLXDk_OQAeuVcp2O", "https://www.youtube.com/playlist?list=PLxCzCOWd7aiGz9donHRrE9I3Mwn6XdP8p", "https://www.youtube.com/watch?v=xw_OuOhjauw" };
            case "CN": return new String[]{ "https://www.youtube.com/playlist?list=PLBlnK6fEyqRgMCUAG0XRw78UA8qnv6jEx", "https://www.youtube.com/playlist?list=PLxCzCOWd7aiGdNpnmgegIDmasG4yvh5jF", "https://www.youtube.com/watch?v=qiQR5rTSshw" };
            case "SQL": return new String[]{ "https://www.youtube.com/watch?v=7S_tz1z_5bA", "https://www.youtube.com/watch?v=HXV3zeQKqGY", "https://www.youtube.com/c/TechTFQ" };
            case "HR": return new String[]{ "https://www.youtube.com/watch?v=0mfDSoJFxqA", "https://www.youtube.com/watch?v=dBOfHua0kOU", "https://www.youtube.com/watch?v=KukmClH1KoA" };
            case "DSA": return getDSAYtLinks(topic);
            case "DBMS": return new String[]{ "https://www.youtube.com/playlist?list=PLxCzCOWd7aiFAN6I8CuViBuCdJgiOkT2Y", "https://www.youtube.com/playlist?list=PLBlnK6fEyqRi_CUQ-FXxgzKQ8dqgvoy1n", "https://www.youtube.com/playlist?list=PLdo5W4Nhv31b33kF46f6aF6qIO5Jm1D3A" };
            case "Aptitude": return new String[]{ "https://www.youtube.com/c/careerride", "https://www.youtube.com/watch?v=H-ShMKs_k7Q", "https://www.youtube.com/c/TalentSprint" };
            default: return new String[]{ "https://www.youtube.com" };
        }
    }

    private static String[] getDSAYtLinks(String topic) {
        switch (topic) {
            case "Arrays": return new String[]{ "https://www.youtube.com/watch?v=37E9ckMDdTk", "https://www.youtube.com/playlist?list=PLgUwDviBIf0rENwdL0nEH0uMom9kjLf7m", "https://www.youtube.com/watch?v=KLlXCFG5TnA" };
            case "Linked List": return new String[]{ "https://www.youtube.com/playlist?list=PLgUwDviBIf0r47RKH7s7GHoZhHSkJzPem", "https://www.youtube.com/watch?v=oAja8-Ulz6o", "https://www.youtube.com/playlist?list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ" };
            case "Dynamic Programming": return new String[]{ "https://www.youtube.com/playlist?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go", "https://www.youtube.com/playlist?list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY", "https://www.youtube.com/watch?v=nqowUJzG-iM" };
            case "Trees": return new String[]{ "https://www.youtube.com/playlist?list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk", "https://www.youtube.com/playlist?list=PL9gnSGHSqcnpYFCkDBO9m2sJBK0Y5GWLK", "https://www.youtube.com/watch?v=fAAZixBzIAI" };
            case "Graphs": return new String[]{ "https://www.youtube.com/playlist?list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn", "https://www.youtube.com/watch?v=M3KZW7946r0", "https://www.youtube.com/playlist?list=PLrmLmBdmIlpu2f2g8ltqaaCZiq6GJvl1j" };
            default: return new String[]{ "https://www.youtube.com/c/takeUforward", "https://www.youtube.com/c/CodeHelp-by-Babbar" };
        }
    }
}
