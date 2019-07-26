package multithread.c02threadsynchronization.synchronizedcodeblock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * BankAccount
 * description:
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
	private String accountNo;
	private double balance;
}
