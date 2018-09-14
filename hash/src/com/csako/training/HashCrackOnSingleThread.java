package com.csako.training;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

public class HashCrackOnSingleThread {
	private String result;
	private String hash;

	public HashCrackOnSingleThread(String hash) {
		this.result = "";
		this.hash = hash;
	}

	public String getResult() {
		return this.result;
	}

	public void crackHash(int length) {

		for (int i = 1; i <= length; i++) {
			generateWords("", i);
		}

	}

	private void generateWords(String base, int length) {
		for (char c = 'a'; c <= 'z' && this.result.equals(""); c++) {
			if (weHaveAWord(length)) {
				inspectWordForResult(base + c);
			} else {
				generateWords(base + c, length - 1);
			}
		}
	}

	private boolean weHaveAWord(int length) {
		return length == 1;
	}

	private void inspectWordForResult(String word) {
		if (hash(word).equals(this.hash)) {
			this.result = word;
		}
	}

	private String hash(String toHash) {
		Hasher hasher = Hashing.md5().newHasher();
		hasher.putString(toHash, StandardCharsets.UTF_8);
		return hasher.hash().toString();
	}

}
