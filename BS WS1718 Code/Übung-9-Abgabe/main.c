#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <time.h>
#include <sys/time.h>
#include <sys/resource.h>
#include <sys/wait.h>

int createChilds(int n, int pInt[], int child_proc_num) {
    int i;
    int pids[n];

    for (i = 0; i < n; i++) {
        fflush(stdout); // prevents textstreams beeing printed by two processes because of buffering
        pids[i] = fork(); // forks and returs PROCESS_ID to parent and 0 to child
        setpriority(PRIO_PROCESS, pids[i], pInt[i]); // sets the prio of processID in pids to the param specified
        if (pids[i] == 0) { //pids[i] == 0 checks if process is the ith child
            child_proc_num = i; // return which child this is for future printings.
            printf("process number: %i, prio: %i\n", child_proc_num, getpriority(PRIO_PROCESS, 0));
            return child_proc_num;
        }

    }
    if (child_proc_num == -1) { // if true, this is the parent
        int time_start = clock();
        for (i = 0; i < n; i++) {
            waitpid(0, 0, 0); // waiting for a process in process group to finish

            printf("a process has finished! - time passed: %i\n", clock() - time_start); // printing info that onoe process died - time calc is a little off because this process has to start again first
            fflush(stdout); // prevents textstreams beeing printed by two processes because of buffering
        }
        printf("waiting process for all childs ended\n");
        fflush(stdout); // prevents textstreams beeing printed by two processes because of buffering
    }
    return -1; // only is reached if this is the parent - returns -1 as parent index constant.
}

int main(int argc, char *argv[]) {
    int i;
    int n = argc - 2;
    int pInt[n];
    for (i = 0; n > i; i++) {
        pInt[i] = atoi(argv[i + 2]); // atoi() makes an integer out of the char * argument.
    }

    if (n != sizeof(pInt) / sizeof(int)) {
        printf("wrong program parameters. Param syntax is: <int n, int[n]>");
        exit(-1);
    }

    pid_t pids[n];
    for (i = 0; i < n; i++) {
        if (pInt[i] < 0 || pInt[i] > 19) {
            printf("wrong program parameters. Nice numbers in the array are limited between 0-19.");
            exit(-1);
        }
    }

    int child_proc_num = -1;
    int proc_num = createChilds(n, pInt, child_proc_num);
    //create child-processe
    //fork between parent and childs
    if (proc_num == -1) {

    } else {

        int run;
        run = 0;
        while (run < 10) { // number in the while-loop here is the amount of runs a process takes
            int time_before = clock();
            for (i = 0; i < 20000; i++) { // big number in the for-loop here is the amount of work a process has to do one time
                int f = i / 2;
                int xxx = i - f;
                int yyy = f - xxx;
                // some sort of useless operation to loose more time
            }
            int time_after = clock();
            time_t time_passed = time_after - time_before;
            printf("Process %i: %i microseconds.\n", proc_num, time_passed);
            fflush(stdout); // prevents textstreams beeing printed by two processes because of buffering
            run++;
        }
        fflush(stdout); // prevents textstreams beeing printed by two processes because of buffering
    }
    exit(0);
}

