// https://school.programmers.co.kr/learn/courses/30/lessons/160585

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        int cntO = 0;
        int cntX = 0;
        
        // 0. 문자열을 배열로 변환하며 O와 X의 개수를 파악
        char[][] tictacto = new char[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                tictacto[i][j] = board[i].charAt(j);
                if(tictacto[i][j] == 'O') cntO++;
                else if(tictacto[i][j] == 'X') cntX++;
            }
        }
        
        // 1. O와 X 개수를 비교
        if(cntO - cntX == 0 || cntO - cntX == 1) {
            // 2. 게임의 승리조건에 도달했는지 체크
            int winO = 0;
            int winX = 0;
            
            // 2-1. 가로&세로 빙고
            for(int i = 0; i < 3; i++) {
                if(tictacto[i][0] == tictacto[i][1] && tictacto[i][1] == tictacto[i][2]) {
                    if(tictacto[i][0] == 'O') winO++;
                    else if(tictacto[i][0] == 'X') winX++;
                }
                if(tictacto[0][i] == tictacto[1][i] && tictacto[1][i] == tictacto[2][i]) {
                    if(tictacto[0][i] == 'O') winO++;
                    else if(tictacto[0][i] == 'X') winX++;
                }
            }  
            
            // 2-2. 대각선 빙고
            if(tictacto[0][0] == tictacto[1][1] && tictacto[1][1] == tictacto[2][2]){
                    if(tictacto[0][0] == 'O') winO++;
                    else if(tictacto[0][0] == 'X') winX++;
            }
            if(tictacto[0][2] != '.' && tictacto[0][2] == tictacto[1][1] && tictacto[1][1] == tictacto[2][0]){
                    if(tictacto[2][0] == 'O') winO++;
                    else if(tictacto[2][0] == 'X') winX++;
                } 
            
            // 3. 승리 조건 체크
            if(winO > 0 && winX > 0) return 0; // 둘 다 이길 수 없다.
            else if(winO > 0 && cntO - cntX != 1) return 0; // O가 이기면 O가 한 개 더 많다.
            else if(winX > 0 && cntO - cntX != 0) return 0; // X가 이기면 O와 X의 개수가 같다.
            answer = 1;
        }
        
        return answer;
    }
}